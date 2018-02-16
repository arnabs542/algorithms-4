/*
*
* LC 721. Accounts Merge
* https://leetcode.com/problems/accounts-merge/description/
*
* */

package union_find;

import java.util.*;

public class accounts_merge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owners = new HashMap<>(); // owner<email, owner>
        Map<String, String> roots = new HashMap<>(); // roots<email, root>
        Map<String, TreeSet<String>> unions = new HashMap<>(); // unions<root, children>

        // initialize the roots map: each email's root is itself; also initialize owners map
        for (List<String> account : accounts) {
            String owner = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                owners.put(email, owner);
                roots.put(email, email);
            }
        }

        // union process
        for (List<String> account : accounts) {
            String root = find(account.get(1), roots);
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                roots.put(find(email, roots), root);
            }
        }

        // put all roots union in unions map, thus making all emails sorted
        for (List<String> account : accounts) {
            String root = find(account.get(1), roots);
            if (!unions.containsKey(root)) unions.put(root, new TreeSet<>());
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                unions.get(root).add(email);
            }
        }

        // change the unions map to list of list
        List<List<String>> result = new LinkedList<>();
        for (String root : unions.keySet()) {
            List emails = new LinkedList(unions.get(root));
            emails.add(0, owners.get(root));
            result.add(emails);
        }

        return result;
    }

    // 用find方法找到这个node/email的root
    private static String find(String s, Map<String, String> roots) {
        return roots.get(s).equals(s) ? s : find(roots.get(s), roots);
    }
}
