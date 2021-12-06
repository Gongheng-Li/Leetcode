import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Set<Integer> seen = new HashSet<>();
                    if (searchNeighbor(board, word, i, j, 0, seen)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean searchNeighbor(char[][] board, String word, int xPos, int yPos, int charPos, Set<Integer> seen) {
        if (charPos >= word.length() - 1) {
            return true;
        }
        seen.add(xPos * board[0].length + yPos);
        boolean left = false, right = false, up = false, down = false;
        if (xPos - 1 >= 0 && board[xPos - 1][yPos] == word.charAt(charPos + 1)
                && !seen.contains((xPos - 1) * board[0].length + yPos)) {
            left = searchNeighbor(board, word, xPos - 1, yPos, charPos + 1, seen);
            if (left) {
                return true;
            }
        }
        if (xPos + 1 < board.length && board[xPos + 1][yPos] == word.charAt(charPos + 1)
                && !seen.contains((xPos + 1) * board[0].length + yPos)) {
            right = searchNeighbor(board, word, xPos + 1, yPos, charPos + 1, seen);
            if (right) {
                return true;
            }
        }
        if (yPos - 1 >= 0 && board[xPos][yPos - 1] == word.charAt(charPos + 1)
                && !seen.contains(xPos * board[0].length + yPos - 1)) {
            up = searchNeighbor(board, word, xPos, yPos - 1, charPos + 1, seen);
            if (up) {
                return true;
            }
        }
        if (yPos + 1 < board[0].length && board[xPos][yPos + 1] == word.charAt(charPos + 1)
                && !seen.contains(xPos * board[0].length + yPos + 1)) {
            down = searchNeighbor(board, word, xPos, yPos + 1, charPos + 1, seen);
            if (down) {
                return true;
            }
        }
        seen.remove(xPos * board[0].length + yPos);
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'},
                          {'S', 'F', 'E', 'S'},
                          {'A', 'D', 'E', 'E'}};
        System.out.println(s.exist(board, "ABCESEEEFS"));
    }
}