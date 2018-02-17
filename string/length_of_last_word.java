/*
*
* 58. Length of Last Word
* https://leetcode.com/problems/length-of-last-word/description/
*
* */

package string;

public class length_of_last_word {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
