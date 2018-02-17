/*
*
* 77. Combinations
* https://leetcode.com/problems/combinations/description/
* --------------------------------------------------------
* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
*
* For example,
* If n = 4 and k = 2, a solution is:
*
* [
*   [2,4],
*   [3,4],
*   [2,3],
*   [1,2],
*   [1,3],
*   [1,4],
* ]
*
* */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinations {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(new ArrayList<>(), n, k, 1);
        return list;
    }

    public void backtrack(List<Integer> temp, int n, int k, int start) {
        if (k == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
