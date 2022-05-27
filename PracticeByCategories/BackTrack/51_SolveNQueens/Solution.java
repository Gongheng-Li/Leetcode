import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] queenPos = new boolean[n][n];
        boolean[] rowOccupied = new boolean[n];
        boolean[] columnOccupied = new boolean[n];
        boolean[] diagonalOccupied = new boolean[2 * n - 1];
        boolean[] subDiagonalOccupied = new boolean[2 * n - 1];
        List<List<String>> result = new ArrayList<>();
        dfs(queenPos, result, 0, columnOccupied, diagonalOccupied, subDiagonalOccupied);
        return result;
    }

    private void dfs(boolean[][] queenPos, List<List<String>> result, int row, boolean[] columnOccupied,
                     boolean[] diagonalOccupied, boolean[] subDiagonalOccupied) {
        int n = queenPos.length;
        if (row == n) {
            List<String> validResult = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (queenPos[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                validResult.add(sb.toString());
            }
            result.add(validResult);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!(columnOccupied[i] || diagonalOccupied[row - i + n - 1] || subDiagonalOccupied[row + i])) {
                    setQueen(row, i, queenPos, columnOccupied, diagonalOccupied, subDiagonalOccupied, true);
                    dfs(queenPos, result, row + 1, columnOccupied, diagonalOccupied, subDiagonalOccupied);
                    setQueen(row, i, queenPos, columnOccupied, diagonalOccupied, subDiagonalOccupied, false);
                }
        }
    }

    private void setQueen(int i, int j, boolean[][] queenPos, boolean[] columnOccupied,
                          boolean[] diagonalOccupied, boolean[] subDiagonalOccupied, boolean status) {
        int n = queenPos.length;
        queenPos[i][j] = status;
        columnOccupied[j] = status;
        diagonalOccupied[i - j + n - 1] = status;
        subDiagonalOccupied[i + j] = status;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solveNQueens(5));
    }
}