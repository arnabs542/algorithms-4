/*
*
*
*
* 给出一系列 不重复的单词，找出所有用这些单词能构成的 单词平方。
* 一系列的单词构成了一个有效的单词矩阵, 如果从第 k 行读出来的单词和第 k 列读出来的单词相同(0 <= k < max(numRows, numColumns))，那么就是一个单词平方.
* 例如，单词序列为 ["ball","area","lead","lady"] ,可以构成一个单词矩阵因为【对于每一行和每一列读出来的单词都是相同的】。
*
* b a l l
* a r e a
* l e a d
* l a d y
*
* 也就是横着读和竖着度一样
*
*  注意事项
* 现在至少有一个单词并且不多于1000个单词
* 所有的单词都有相同的长度
* 单词的长度最短为 1 最长为 5
* 每一个单词均由小写字母组成
*
* 思路：DFS + pruning
*
* 剪枝思路：
*
* 1. 第一个词是ball了之后，第二个词（第二行）必须以a开头
* 2. 第二个词是area了之后，第三个词（第三行）必须以le开头，如果以其他字母开头的话，就进行剪枝
* 3. 同时填了ball和area之后，字典里必须有le和la开头的词
*
* 实现方式：用hash或者trie记录前缀树
*
*
* */

package DFS;

import java.util.List;

public class word_squares {
//    public List<List<String>> wordSquares(String[] words) {
//
//    }
}
