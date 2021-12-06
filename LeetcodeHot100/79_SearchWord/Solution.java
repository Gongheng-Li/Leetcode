class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (searchNeighbor(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean searchNeighbor(char[][] board, String word, int x, int y, int index, boolean[][] visited) {
        if (index == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        index += 1;
        char target = word.charAt(index);
        if ( x > 0 && !visited[x - 1][y] && board[x - 1][y] == target) {
            if (searchNeighbor(board, word, x - 1, y, index, visited)) {
                return true;
            }
        }
        if (y > 0 && !visited[x][y - 1] && board[x][y - 1] == target) {
            if (searchNeighbor(board, word, x, y - 1, index, visited)) {
                return true;
            }
        }
        if (x < board.length - 1 && !visited[x + 1][y] && board[x + 1][y] == target) {
            if (searchNeighbor(board, word, x + 1, y, index, visited)) {
                return true;
            }
        }
        if (y < board[0].length - 1 && !visited[x][y + 1] && board[x][y + 1] == target) {
            if (searchNeighbor(board, word, x, y + 1, index, visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        Solution s = new Solution();
        System.out.println(s.exist(board, "AAB"));
    }
}