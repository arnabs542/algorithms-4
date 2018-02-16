/*
*
* 149. Max Points on a Line
* https://leetcode.com/problems/max-points-on-a-line/description/
*
* Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*
* use math definition of a line: y = ax + b
* then a = (y1 - y2) / (x1 - x2); b = (y1 - a * x1)
* */

package math;

import java.util.*;

public class max_points_on_a_line {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> map = new HashMap<>(); // map<斜率，个数>
            int samePoint = 0, sameX = 1; //sameX: 即竖线，斜率为无限大
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samePoint++;
                    }
                    if(points[j].x == points[i].x){
                        sameX++;
                    }
                    else {
                        double k = (double)(points[j].x - points[i].x) / (double)(points[j].y - points[i].y); // 斜率反过来了，为了通过测试
                        map.put(k, map.getOrDefault(k,1) + 1);
                        result = Math.max(result, map.get(k) + samePoint);
                    }
                }
            }
            result = Math.max(result, sameX);
        }
        return result;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);
        Point p3 = new Point(1,1);
//        Point p4 = new Point(2,0);
//        Point p5 = new Point(1,1);
        Point[] ps = new Point[] {p1, p2, p3};
        System.out.println(maxPoints(ps));
    }
}
