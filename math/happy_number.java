/*
*
* LC 202. Happy Number
*
* Write an algorithm to determine if a number is "happy".
*
* A happy number is a number defined by the following process: Starting with any 【positive integer】,
* replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
* (where it will stay), or it loops endlessly in a 【cycle】 which does not include 1.
* Those numbers for which this process ends in 1 are happy numbers.
*
* Example: 19 is a happy number
*
* 12 + 92 = 82
* 82 + 22 = 68
* 62 + 82 = 100
* 12 + 02 + 02 = 1
*
* */

package math;

import java.util.HashSet;
import java.util.Set;

public class happy_number {
    // method 1: set, O(n) space
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) return false;
            set.add(n);
            int temp = 0;
            while (n != 0) {
                temp += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = temp;
            System.out.println(n);
        }
        return true;
    }

    // method 2: O(1) space, fast runner slow runner solution
    // slow runner每次calculate一次，fast runner每次calculate两次
    // slow 和 fast总会遇到，就看遇到的地方是1还是不是1
    public static boolean isHappy2(int n) {
        int slow = n, fast = n;
        while (slow > 1) {
            slow = calculate(slow);
            fast = calculate(calculate(fast));
            if (slow == 1 || fast == 1) return true;
            if (slow == fast) return false;
        }
        return true;
    }

    private static int calculate(int n) {
        int temp = 0;
        while (n != 0) {
            temp += Math.pow(n % 10, 2);
            n /= 10;
        }
        return temp;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
