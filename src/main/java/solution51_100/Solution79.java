package solution51_100;

/**
 * 79. 单词搜索
 * created at 2019/12/28
 *
 * @author shixi
 */
public class Solution79 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean exist = dfs(board, word, 0, i, j);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int wordIndex, int i, int j) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (board[i][j] == word.charAt(wordIndex)) {
            char c = board[i][j];
            board[i][j] = ' ';
            boolean down = dfs(board, word, wordIndex + 1, i + 1, j);
            boolean right = dfs(board, word, wordIndex + 1, i, j + 1);
            boolean up = dfs(board, word, wordIndex + 1, i - 1, j);
            boolean left = dfs(board, word, wordIndex + 1, i, j - 1);
            if (down || right || up || left) {
                return true;
            }
            board[i][j] = c;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        boolean exist = solution79.exist(board, word);
        System.out.println(exist);
    }
}
