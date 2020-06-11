Supplementary Material for Geocaching-inspired Navigation
for Micro Aerial Vehicles with Fallible Place Recognition
===

### Michel Barbeau, Carleton University, School of Computer Science, Canada.

### Joaquin Garcia-Alfaro, Institut Polytechnique de Paris, Telecom SudParis, France.

### Evangelos Kranakis, Carleton University, School of Computer Science, Canada.

## Abstract

We add a decisional framework to a navigation algorithm for a swarm of
Micro Aerial Vehicles (MAVs) [1]. The algorithm finds inspiration in
the geocaching outdoor game and leverages place recognition methods,
information sharing and collaborative work between MAVs. It is unique
in that a priori none of the MAVs knows the trajectory, waypoints and
destination. The MAVs collectively solve a series of problems that
involves the recognition of physical places and determination of their
GPS coordinates. Our algorithm builds upon various methods that had
been created for place recognition. The need for a decisional
framework comes from the fact that all methods are fallible and make
place recognition errors. In this paper, we augment the navigation
algorithm with a decisional framework resolving conflicts resulting
from errors made by place recognition methods. The errors divide the
members of a swarm with respect to the location of waypoints. We
propose four decisional algorithms to resolve conflicts among members
of a swarm due to place recognition errors. The performance the
performance of the decisional algorithms is modeled and analyzed.

## Keywords

Micro Aerial Vehicle; Drone Formation Control; Drone Swarm; Goal
Location; Quadcopter; Information Sharing; Localization; Path
Planning; Navigation; Place Recognition.

## Incremental Path Construction Algorithm

Figure 1 depicts the idea of the navigation algorithm for swarm of
Micro Aerial Vehicles (MAVs) introduced in Ref. [1]. The algorithm is
one of its kind in that it adopts an information sharing and
collaborative model. It also finds inspiration in the geocaching
outdoor recreational activity.

![figure1](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/AlgoRef1.png)
#### Figure 1. Incremental path construction algorithm illustrated. Pictures (a), (b), and (c) constitute steps required to determine the next waypoint, while picture (d) depicts a resulting path.

## Extended Algorithms

![figure2](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algo1.png)

![figure3](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algo2.png)

![figure4](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algo3.png)

![figure5](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algo4.png)

## Numeric Results

#### Summary

<img src="https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm-results-1-to-4.png" width="75%"  />


#### Algorithm 1, 10 to 90 MAVs.
![figure6](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm1-n10-90.png)

#### Algorithm 2, 10 to 90 MAVs, with 3 place recognition indicators.
![figure8](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm2-m=3.png)

#### Algorithm 2, 10 to 90 MAVs, with 5 place recognition indicators.
![figure9](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm2-m=5.png)

#### Algorithm 2, 10 to 90 MAVs, with 7 place recognition indicators.
![figure10](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm2-m=7.png)

#### Algorithm 2, 10 to 90 MAVs, with 10 place recognition indicators.
![figure11](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm2-m=10.png)

#### Algorithm 3, 10 to 90 MAVs, with 3 place recognition indicators.
![figure12](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm3-m=3.png)

#### Algorithm 3, 10 to 90 MAVs, with 5 place recognition indicators.
![figure13](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm3-m=5.png)

#### Algorithm 3, 10 to 90 MAVs, with 7 place recognition indicators.
![figure14](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm3-m=7.png)

#### Algorithm 3, 10 to 90 MAVs, with 10 place recognition indicators.
![figure15](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm3-m=10.png)

#### Algorithm 4, 10 to 90 MAVs, with 3 place recognition indicators.
![figure16](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm4-m=3.png)

#### Algorithm 4, 10 to 90 MAVs, with 4 place recognition indicators.
![figure17](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm4-m=5.png)

#### Algorithm 4, 10 to 90 MAVs, with 7 place recognition indicators.
![figure18](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm4-m=7.png)

#### Algorithm 4, 10 to 90 MAVs, with 10 place recognition indicators.
![figure19](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algorithm4-m=10.png)

## Simulation Results [ongoing work]

The numeric simulations depicted in previous figures are extended in
this section. We have implemented our decisional framework and
algorithms in a Java simulation, to conduct Montecarlo simulations. We
show below some ongoing results in which all four algorithm assume an
incremental number of MAVs (from 10 to 90 MAVs), randomized failure
ratios reported in the literature of navigation systems, visual
recognition, environmental sound and thermal infrared imaging, etc.
The simulation aims at evaluating the chances of mission success of
the swarm. Mission success means that the swarm succeeds at visiting
all the way points of the path and reaches the final destination.

#### Montecarlo Simulation 

![figureGUI](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/GUI.gif)

#### Early Results

![figureMontecarlo](https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Montecarlo-results.png)

#### cf. (https://github.com/jgalfaro/mirrored-geomav/blob/master/code/java)



## References

[1] M. Barbeau, J. Garcia-Alfaro, and E. Kranakis, Geocaching-inspired Resilient
Path Planning for Drone Swarms, in IEEE Conference on Computer
Communications (IEEE INFOCOM 2019) Workshops, April 2019, pp. 620-625.
[Online]. Available at https://doi.org/10.1109/INFCOMW.2019.8845318

