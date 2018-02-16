/*
*
* 319. Bulb Switcher
* https://leetcode.com/problems/bulb-switcher/description/
* 参考：
* https://leetcode.com/problems/bulb-switcher/discuss/77132
*
* 核心：找odd-operation numbers
* */

package math;

public class bulb_switcher {
    public static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(6));
    }
}
