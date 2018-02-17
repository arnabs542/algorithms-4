/*
*
* 93. Restore IP Addresses
* https://leetcode.com/problems/restore-ip-addresses/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given a string containing only digits, restore it by returning all possible valid IP address combinations.
* For example:
* Given "25525511135",
*
* return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*
* 思路：每个数字都在0~255之间
*
* */

package DFS;

import java.util.ArrayList;
import java.util.List;

public class restore_ip_address {
    /*------------Method 1: 分成4个string (0~3),加起来长度等于s.length()------------------*/
    public List<String> restoreIpAddresses1(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    for (int d = 1; d <= 3; d++) {
                        // 判断4个string的长度加起来是否等于s的长度
                        if (a + b + c + d == s.length()) {
                            // could have 0 as leading digit
                            int num1 = Integer.parseInt(s.substring(0, a));
                            int num2 = Integer.parseInt(s.substring(a,a + b));
                            int num3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int num4 = Integer.parseInt(s.substring(a + b + c));
                            if (num1 <= 255 && num2 <= 255 & num3 <= 255 & num4 <= 255) {
                                sb.append(num1).append(".").append(num2).append(".").append(num3).append(".").append(num4);
                                // if there are no leading 0s
                                if (sb.length() == s.length() + 3) list.add(sb.toString());
                                sb = new StringBuilder();
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    /*------------Method 2: 分成4个string (s分为4个部分),加起来长度等于s.length(-----------*/
    public List<String> restoreIpAddresses2(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i <= 3 && i <= len - 3; i++) {
            for (int j = i + 1; j <= i + 3 && j <= len - 2; j++) {
                for (int k = j + 1; k <= j + 3 && k <= len - 1; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    if (validIP(s1) && validIP(s2) && validIP(s3) && validIP(s4)) list.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return list;
    }
    private boolean validIP(String s) {
        return !(s.length() > 3 || s.length() == 0 || s.length() > 1 && s.charAt(0) == '0' || Integer.parseInt(s) > 255);
    }

    /*--------------------------Method 3: backtracking---------------------------------*/
    public List<String> restoreIpAddresses3(String s) {
        List<String> list = new ArrayList<>();
        DFS(s, list, 0, "", 0);
        return list;
    }
    // 不算backtrack，因为没有往回走（因为ip是连续的，不像backtrack求的是"组合"）
    private void DFS(String ip, List<String> list, int index, String temp, int count) {
        if (count > 4) return;
        if (count == 4 && index == ip.length()) list.add(temp);
        for (int i = 1; i <= 3; i++) {
            if (index + i > ip.length()) break;
            String s = ip.substring(index, index + i);
            // 排除0开头的和>255的string
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) > 255)) continue;
            DFS(ip, list, index + i, temp + s + (count == 3 ? "" : "."), count + 1);
        }
    }
}
