/*
*
* 60. Permutation Sequence
* https://leetcode.com/problems/permutation-sequence/description/
* ----------------------------------------------------------------
* The set [1,2,3,…,n] contains a total of n! unique permutations.
*
* By listing and labeling all of the permutations in order,
* We get the following sequence (ie, for n = 3):
*
* "123"
* "132"
* "213"
* "231"
* "312"
* "321"
* Given n and k, return the kth permutation sequence.
*
* Note: Given n will be between 1 and 9 inclusive.
*
* 问第k个permutation是什么
*
* 思路：
*
* 找到如下规律
* say n = 4, you have {1, 2, 3, 4}
*
* If you were to list out all the permutations you have
*
* 1 + (permutations of 2, 3, 4)
*
* 2 + (permutations of 1, 3, 4)
*
* 3 + (permutations of 1, 2, 4)
*
* 4 + (permutations of 1, 2, 3)
*
* */

package math;

import java.util.LinkedList;
import java.util.List;

public class permutation_sequence {
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new LinkedList<>();
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
            list.add(i);
        }

        // l是剩余的，代表left，被用来除以fact来算list中的index
        // list中的index很巧妙，考虑到用list.remove(index)，代表剩下的list中的元素的位置
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = l / fact;
            sb.append(list.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 5));
    }
}
