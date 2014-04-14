MatrixDemo
==========

Simple demonstration of matrix manipulations in Java

The Matrix class provides functions to add, multiply, or amplify a given matrix,
or to check if it is a null matrix (all 0's) or unit matrix (all 1's)

(I/O seemed tedious and out of scope for this size a project, but the values in Main.java may be
updated to different values for testing.)

The default values (and the ones baked into the .jar file in /bin) are:
Amplifier: 2
Matrix X:
        --     --
				|1, 2, 3|
				|2, 3, 4|
				|3, 4, 5|
        --     --
Matrix Y:
        --     --
				|2, 2, 2|
				|1, 3, 1|
				|1, 2, 3|
        --     --

The formula run on these variables:
 (2 * X) + Y
