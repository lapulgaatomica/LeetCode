package blind75.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}}));
        System.out.println(isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}}));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                final char currentChar = board[i][j];
                if (!seen.add(currentChar + "@row" + i) || !seen.add(currentChar + "@col" + j) || !seen.add(currentChar + "@box" + i / 3 + j / 3))
                    return false;
            }

        return true;
    }
}
