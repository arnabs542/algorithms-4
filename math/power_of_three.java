/*
*
* LC 326. Power of Three
* https://leetcode.com/problems/power-of-three/description/
*
* Given an integer, write a function to determine if it is a power of three.
*
* */

package math;

public class power_of_three {
    final int Max3PowerInt = 1162261467; // 3^19, 3^20 = 3486784401 > MaxInt32
    final int MaxInt32 = 2147483647; // 2^31 - 1
    boolean isPowerOfThree(int n) {
        if (n <= 0 || n > Max3PowerInt) return false;
        return Max3PowerInt % n == 0;
    }
}
