import java.awt.BasicStroke;
import java.awt.Stroke;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Robot;
import java.util.Random;


public class Montecarlo{


    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        boolean useRobot = Sim.robot;

        GraphicImagePanel g =new GraphicImagePanel();
        JScrollPane gg = new JScrollPane(g, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        f.getContentPane().add(gg);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1080,540);
        f.setLocation(0,0);
        f.setVisible(true);

        System.out.format("\n");

        if(useRobot){
            for(int a=1;a<5;a++){
                Sim.algorithm=a;
                System.out.print("Algorithm="+Sim.algorithm+"\n");
                for(int n=0;n<9;n++){
                    Sim.ncase=n;
                    System.out.print("n"+Sim.numberMAV[Sim.ncase]+"={");
                    for(int i=0;i < 10;i++){
                        Sim.successCounter=0;
                        for(int j=0;j < 100;j++){
                            try {
                                Robot robot = new Robot();

                                robot.keyPress(KeyEvent.VK_N);
                                robot.keyRelease(KeyEvent.VK_N);
                                try{
                                    //Pause for 0.1 seconds
                                    Thread.sleep(10);
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }//try_pause

                            } catch (AWTException e) {
                                e.printStackTrace();
                            }//try_robot
                        }//for_j
                        System.out.print(Sim.successCounter+",");
                    }//for_i
                    System.out.print(Sim.successCounter+"}\n");
                }//for_n
            }//for_a
            System.exit(0);
        }//if
    }//main

}//Montecarlo class

class GraphicImagePanel extends JPanel implements KeyListener{


    Image image;
    Ellipse2D.Double SWARM;


    @Override
    public void keyPressed(KeyEvent e) {
        //SIMULATION
        //System.out.println("\n KeyPressed");
        int k = e.getKeyCode();
        int pointer = 0;
        int ncase=Sim.ncase;//0 to 8, i.e., 10 to 90 MAVs

        switch (k) {
            case KeyEvent.VK_N://Move to Next Waypoint
                Sim.round=Sim.round+1;
                if(Sim.step<Sim.currentX.length-1){
                    Sim.step=Sim.step+1;
                }else{
                    Sim.step=0;
                }
                pointer=Sim.step;
                mover.moveNextWayPoint(Sim.round,pointer,Sim.currentX[pointer],Sim.currentY[pointer],Sim.numberMAV[ncase],ncase);//move
                break;
            case KeyEvent.VK_O:
                //System.out.println("\n KeyPressed==O");
                mover.moveLeft();
                break;
            case KeyEvent.VK_P:
                //System.out.println("\n KeyPressed==P");
                mover.moveRight();
                break;
            case KeyEvent.VK_Q:
                //System.out.println("\n KeyPressed==Q");
                mover.moveUp();
                break;
            case KeyEvent.VK_A:
                //System.out.println("\n KeyPressed==A");
                mover.moveDown();
                break;
            default:
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("\n KeyTyped");
        //mover.moveUAVPos();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("\n KeyReleased");
    }

    GraphicMover mover;

    public GraphicImagePanel()
    {
        loadImage();
        SWARM = new Ellipse2D.Double(2,94,30,30); //SWARM starts at pixel 2,94
        mover = new GraphicMover(this);
        addMouseListener(mover);
        addMouseMotionListener(mover);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
    }

    protected void paintComponent(Graphics g)
    {
        Color DarkGreen = new Color(0, 153, 250); // http://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        int x = (w - imageWidth)/2;
        int y = (h - imageHeight)/2;
        g2.drawImage(image, x, y, this);
        g2.setPaint(DarkGreen);
        g2.setStroke(new BasicStroke(6f));
        g2.draw(SWARM);
    }

    private void loadImage()
    {
        String fileName = "bg.png";
        try
        {
            URL url = getClass().getResource(fileName);
            BufferedImage myImage = ImageIO.read(url);
            //50% scale of the previous picture (e.g., from 2160x1080 to 1080,540)
            Image dimg = myImage.getScaledInstance(1080, 540, // 2160/2 & 1080/2
                                               Image.SCALE_SMOOTH);
            image = dimg; //scaled (50%,50%) picture
            //image = myImage;//full_scale_picture
        }

        catch(MalformedURLException mue)
        {
            System.err.println(mue.getMessage());
        }
        catch(IOException ioe)
        {
            System.err.println(ioe.getMessage());
        }
    }
}

class GraphicMover extends MouseInputAdapter{

    GraphicImagePanel imagePanel;
    Point2D.Double offset;
    boolean dragging;

    public GraphicMover(GraphicImagePanel gip)
    {
        imagePanel = gip;
        offset = new Point2D.Double();
        dragging = false;
    }

    public void mousePressed(MouseEvent e)
    {
        Point p = e.getPoint();
        if(imagePanel.SWARM.contains(p.x, p.y))
        {
            System.out.println("\n SWARM is at "+imagePanel.SWARM.x+","+imagePanel.SWARM.y);
            offset.x = p.x - imagePanel.SWARM.x;
            offset.y = p.y - imagePanel.SWARM.y;
            dragging = true;
        }//else{
        //    System.out.println("\n Pointer not in SWARM");
        //    moveRight();
        //}
    }

    public void moveNextWayPoint(int round,int step, int NewX, int NewY, double numMAVs, int ncase)
    {
        Random rand = new Random();
        double chosenErrorProb=0;
        int algorithm=Sim.algorithm;


        //SIMULATION
        imagePanel.SWARM.x = NewX;
        imagePanel.SWARM.y = NewY;


        //System.out.print("["+step+",X="+imagePanel.SWARM.x+",Y="+imagePanel.SWARM.y+",MAVs="+numMAVs+"]\n");

        int success=0;
        int numValues=Sim.algoErrorProb[algorithm-1][ncase].length;//algoErrorValues from matlab simulations

        //Compute success
        //System.out.print("Algorithm="+algorithm+", ncase="+ncase+", numValues="+numValues+", algoErrorProb:\n");
        //for(int i=0;i<Sim.algoErrorProb[algorithm-1][ncase].length;i++){
        //    chosenErrorProb=Sim.algoErrorProb[algorithm-1][ncase][rand.nextInt(numValues)];
        //    System.out.print("i="+i+" "+Sim.algoErrorProb[algorithm-1][ncase][i]+", chosen="+chosenErrorProb+"\n");
        //}
        chosenErrorProb=Sim.algoErrorProb[algorithm-1][ncase][rand.nextInt(numValues)];
        if(Math.random() > chosenErrorProb){
            success=1;
            Sim.successCounter+=1;
            //System.out.print("["+round+","+step+","+"Algorithm="+algorithm+",MAVs="+numMAVs+",success="+success+"]\n");
            if(Sim.verbose){
                System.out.print("success="+success+"\n");
            }
        }else{
            if(Sim.verbose){
                success=0;
                System.out.print("success="+success+"\n");
                //system.out.print("["+round+","+step+","+"Algorithm="+algorithm+",MAVs="+numMAVs+",success="+success+"]\n");
            }
        }


        //System.out.print("["+round+","+step+","+"MAVs="+numMAVs+",values="+numValues+",chosen="+chosen+"]\n");

        //System.out.print("["+round+","+step+","+"Algo=1, MAVs="+numMAVs+",success="+success+"]\n");

        //50%+1 majority?
        //         if(
        //         +"]\n");

        imagePanel.repaint();

    }

    public void moveLeft()
    {
        //System.out.println("\n MoveLeft");
        System.out.print("\n"+imagePanel.SWARM.x+"\t"+imagePanel.SWARM.y);
        imagePanel.SWARM.x -=2;
        imagePanel.repaint();
    }

    public void moveRight()
    {
        System.out.println("\n MoveRight");
        System.out.print("\n"+imagePanel.SWARM.x+"\t"+imagePanel.SWARM.y);
        imagePanel.SWARM.x +=2;
        imagePanel.repaint();
    }

    public void moveUp()
    {
        //System.out.println("\n MoveUp");
        System.out.print("\n"+imagePanel.SWARM.x+"\t"+imagePanel.SWARM.y);
        imagePanel.SWARM.y -=2;
        imagePanel.repaint();
    }

    public void moveDown()
    {
        //System.out.println("\n MoveDown");
        System.out.print("\n"+imagePanel.SWARM.x+"\t"+imagePanel.SWARM.y);
        imagePanel.SWARM.y +=2;
        imagePanel.repaint();
    }

    public void mouseReleased(MouseEvent e)
    {
        dragging = false;
    }

    public void mouseDragged(MouseEvent e)
    {
        if(dragging)
        {
            imagePanel.SWARM.x = e.getX() - offset.x;
            imagePanel.SWARM.y = e.getY() - offset.y;
            imagePanel.repaint();
        }
    }
}
