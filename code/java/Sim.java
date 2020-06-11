// Simulations from paper:
// "Geocaching-inspired Navigation for Micro Aerial Vehicles with Fallible
// Place Recognition"
// authored by: Michel Barbeau, Joaquin Garcia-Alfaro and Evangelos Kranakis
// Version: June 11, 2020

//Sample Path (pathLength=7)
//  0          1           2           3           4          5           6
//2,94 --> 230,255 --> 400,206 --> 490,262 --> 739,243 --> 920,369 --> 1041,187


class Sim {
    static boolean robot=true;
    static boolean verbose=false;
    static int algorithm=1;
    static int round=0; //simulation round counter
    static int step=0; //simulation step counter
    static int pathLength=20; //up to 20 waypoints ( 7 \times 3 - 1)
    static double[] numberMAV= new double[] {10.00,20.00,30.00,40.00,50.00,60.00,70.00,80.00,90.00}; //up to 90 MAVs
    static int[] currentX = new int[] {2,230,400,490,739,920,1041,2,230,400,490,739,920,1041,2,230,400,490,739,920}; //only if GUI enabled
    static int[] currentY = new int[] {94,255,206,262,243,369,187,94,255,206,262,243,369,187,94,255,206,262,243,369}; //only if GUI enabled
    static double[][] algoErrorProb = new double[][] { //comes from the matlab simulations, Dim1= n, Dim2= values in Algo1.png & n
        //values directly from simulations/figures-7-10/matlab/algo1.m, log2java function
        {0.000000,0.000003,0.000147,0.001383,0.006369,0.019728,0.047349,0.094934,0.166239,0.261563,0.376953},//n=10
        {0.000000,0.000000,0.000001,0.000039,0.000563,0.003942,0.017145,0.053167,0.127521,0.249289,0.411901}, //n=20
        {0.000000,0.000000,0.000000,0.000001,0.000052,0.000819,0.006370,0.030084,0.097057,0.230909,0.427768}, //n=30
        {0.000000,0.000000,0.000000,0.000000,0.000005,0.000175,0.002419,0.017281,0.074352,0.213044,0.437315}, //n=40
        {0.000000,0.000000,0.000000,0.000000,0.000000,0.000038,0.000933,0.010044,0.057344,0.196631,0.443862}, //n=50
        {0.000000,0.000000,0.000000,0.000000,0.000000,0.000008,0.000364,0.005890,0.044480,0.181729,0.448711}, //n=60
        {0.000000,0.000000,0.000000,0.000000,0.000000,0.000002,0.000143,0.003478,0.034666,0.168218,0.452481}, //n=70
        {0.000000,0.000000,0.000000,0.000000,0.000000,0.000000,0.000057,0.002066,0.027124,0.155948,0.455536}, //n=80
        {0.000000,0.000000,0.000000,0.000000,0.000000,0.000000,0.000023,0.001232,0.021292,0.144776,0.458064} //n=90
    };//algoErrorProb

    //static int[] algorithm = new int[] {1,2,3,4}; // 4 TODO, add below a third dimension, based on the algorith
    //static int[] m = new int[] {3,5,7,10}; // TODO, add below a fourth dimension, based on the values of m

    static int successCounter=0;

}


