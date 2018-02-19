/*
*
* 118. Pascal's Triangle
* https://leetcode.com/problems/pascals-triangle/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given numRows, generate the first numRows of Pascal's triangle.
* For example, given numRows = 5,
* Return
*
* [
*      [1],
*     [1,1],
*    [1,2,1],
*   [1,3,3,1],
*  [1,4,6,4,1]
* ]
*
* */

package array;

import java.util.ArrayList;
import java.util.List;

public class pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0,1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            list.add(new ArrayList<>(row));
        }
        return list;
    }
}
