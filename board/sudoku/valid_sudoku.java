package board.sudoku;/*
*
* 36. Valid Sudoku
* https://leetcode.com/problems/valid-sudoku/description/
*
* The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
* A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*
* */

import java.util.HashSet;
import java.util.Set;

public class valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            // 3 sets
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cubes = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && rows.contains(board[i][j])) return false; // board[i][j]
                rows.add(board[i][j]);
                if (board[j][i] != '.' && cols.contains(board[j][i])) return false; // board[j][i]
                cols.add(board[j][i]);
                // cubeRow和cubeCol前半部分决定哪个cube，后半部分决定cube中哪个block
                int cubeRow = 3 * (i / 3) + j / 3;
                int cubeCol = 3 * (i % 3) + j % 3;
                if (board[cubeRow][cubeCol] != '.' && cubes.contains(board[cubeRow][cubeCol])) return false;
                cubes.add(board[cubeRow][cubeCol]);
            }
        }
        return true;
    }
}
