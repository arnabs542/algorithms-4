/*
*
* 17. Letter Combinations of a Phone Number
* https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*
* */

package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class letter_combination_of_a_phone_number {
    /*DFS solution*/
    List<String> result = new ArrayList<>();
    String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinationsDFS(String digits) {
        if (digits == null || digits.length() == 0) return result;
        dfs(0, digits.length(), "", digits);
        return result;
    }
    void dfs(int currentLevel, int totalLevel,  String temp, String digits) {
        if (currentLevel == totalLevel) {
            result.add(temp);
            return;
        }
        int mapIndex = digits.charAt(currentLevel) - '0';
        for (char c : map[mapIndex].toCharArray()) {
            dfs(currentLevel + 1, totalLevel, temp + c, digits);
        }
    }

    /*BFS solution*/
    // 每一层用一个for-loop增加一个字母，并把所有可以增加的情况push到queue里去
    public List<String> letterCombinationsBFS(String digits) {
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 这里必须是LinkedList，因为只有LinkedList才能用poll()
        LinkedList<String> queue = new LinkedList<>();
        if (digits == null || digits.length() == 0) return queue;
        queue.add("");
        for (int i = 0; i < digits.length(); i++) {
            int mapIndex = digits.charAt(i) - '0';
            while (queue.peek().length() == i) {
                String str = queue.poll();
                for (char c : map[mapIndex].toCharArray()) queue.add(str + c);
            }
        }
        return queue;
    }

    /*backtracking DFS solution*/
    List<String> result1 = new ArrayList<>();
    int totalLevel;
    String digits;
    StringBuilder sb = new StringBuilder();
    String[] map1 = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        this.totalLevel = digits.length();
        this.digits = digits;
        if (digits.length() == 0) return result1;
        backtrack(0);
        return result1;
    }

    void backtrack(int currentLevel) {
        if (currentLevel == totalLevel) {
            result1.add(sb.toString());
            return;
        }
        int mapIndex = digits.charAt(currentLevel) - '0';
        for (char c : map1[mapIndex].toCharArray()) {
            sb.append(c);
            backtrack(currentLevel + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
