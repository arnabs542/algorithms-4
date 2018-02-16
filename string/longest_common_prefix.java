/*
*
* Write a function to find the longest common prefix string amongst an array of strings.
*
* 思路：给string array排序，比较排序后的第一个和最后一个string
* */

package string;

import java.util.Arrays;

public class longest_common_prefix {
    // sort the array
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        StringBuilder sb = new StringBuilder();
        // 注意first可能比last长
        int i = 0;
        while (i < first.length && i < last.length && first[i] == last[i]) {
            sb.append(first[i]);
            i++;
        }
        return sb.toString();
    }
}
