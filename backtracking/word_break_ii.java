package backtracking;/*
*
* 140. Word Break II
* https://leetcode.com/problems/word-break-ii/description/
* http://lintcode.com/zh-cn/problem/word-break-ii/
*
* 输入lintcode
* dictionary: [“de”, “ding”, “co”, “code”, “lint”, “li”]
*
* 结果为: ["lint code", "lint co de"]
*
* 思考CEO-总监这一层，即最后一步需要干什么
* 进行拆分：
*   lintcode: lint + 拆分（code）
*   lintcode: li + 拆分（ntcode）
*
* 上面的例子中"code"可能会重复计算，所以用"记忆化搜索"来避免重复
*
* */

import java.util.*;

public class word_break_ii {
    // 用map实现记忆化搜索
    Map<String, List<String>> doneMap = new HashMap<>();
    List<String> dict;
    public List<String> wordBreak(String s, List<String> dict) {
        this.dict = dict;
        // 考虑s为empty string的情况
        doneMap.put("", new ArrayList<>());
        doneMap.get("").add("");
        return dfs(s);
    }

    List<String> dfs(String s) {
        // base case, 如果已经map中包含了s（工作已经完成）
        if (doneMap.containsKey(s)) return doneMap.get(s);

        // 如果map不包含s，工作还要继续做
        List<String> result = new ArrayList<>();
        // 将s拆分为s1与s2，其中s1的长度为len
        for (int len = 1; len <= s.length(); len++) {
            String s1 = s.substring(0, len);
            String s2 = s.substring(len);
            if (dict.contains(s1)) {
                List<String> s2_list = dfs(s2); // 把s2交给总监去做
                // 做完之后给每个结果前都加上s1
                for (String item : s2_list) {
                    if (item == "") result.add(s1);
                    else result.add(s1 + " " + item);
                }
            }
        }
        doneMap.put(s, result);
        return result;
    }
}
