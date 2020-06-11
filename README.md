Supplementary Material for Geocaching-inspired Navigation
for Micro Aerial Vehicles with Fallible Place Recognition
===

### Michel Barbeau, Carleton University, School of Computer Science, Canada.

### Joaquin Garcia-Alfaro, Institut Polytechnique de Paris, France.

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

https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algo1.png

https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algo2.png

https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algo3.png

https://github.com/jgalfaro/mirrored-geomav/blob/master/figures/Algo4.png


## References

[1] M. Barbeau, J. Garcia-Alfaro, and E. Kranakis, Geocaching-inspired Resilient
Path Planning for Drone Swarms, in IEEE Conference on Computer
Communications (IEEE INFOCOM 2019) Workshops, April 2019, pp. 620-625.
[Online]. Available at https://doi.org/10.1109/INFCOMW.2019.8845318

