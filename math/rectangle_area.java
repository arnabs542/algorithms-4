/*
*
* 223. Rectangle Area
* https://leetcode.com/problems/rectangle-area/description/
*
* Find the total area covered by two rectilinear rectangles in a 2D plane.
* Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
*
*
* */

package math;

public class rectangle_area {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOfSqrA = (C-A) * (D-B);
        int areaOfSqrB = (G-E) * (H-F);
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        // check if there is an overlapping area
        int overlap = 0;
        if (left < right && bottom < top) overlap = (right - left) * (top - bottom);
        return areaOfSqrA + areaOfSqrB - overlap;
    }
}
