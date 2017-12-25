package fb;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordSearch_79 {

    public static boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfsHelper(board, i, j, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsHelper(char[][] board, int i, int j, String word, boolean[][] visited) {
        if (word.isEmpty()) {
            return true;
        }

        boolean rst = false;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return rst;
        }

        if (!visited[i][j] && word.charAt(0) == board[i][j]) {
            visited[i][j] = true;
            String subWord = word.substring(1);
            rst = dfsHelper(board, i + 1, j, subWord, visited)
                    || dfsHelper(board, i - 1, j, subWord, visited)
                    || dfsHelper(board, i, j + 1, subWord, visited)
                    || dfsHelper(board, i, j - 1, subWord, visited);
            visited[i][j] = false;
        }
        return rst;
    }


    public static void main(String[] args) {
//        char c = 'a';
//        c ^= 256;
//        System.out.println(c);
//        c ^= 256;
//        System.out.println(c);
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        assertTrue(exist(board, "ABCCED"));
        assertTrue(exist(board, "SEE"));
        assertFalse(exist(board, "ABCB"));
    }
}
