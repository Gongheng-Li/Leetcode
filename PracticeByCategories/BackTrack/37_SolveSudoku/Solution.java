class Solution {
    public void solveSudoku(char[][] board) {
        int[] existsInRow = new int[9];
        int[] existsInColumn = new int[9];
        int[] existsInSquare = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    existsInRow[i] |= 1 << num;
                    existsInColumn[j] |= 1 << num;
                    existsInSquare[(i / 3) * 3 + j / 3] |= 1 << num;
                }
            }
        }
        dfs(board, 0, 0, existsInRow, existsInColumn, existsInSquare);
    }

    private boolean dfs(char[][] board, int row, int column, int[] existsInRow, int[] existsInColumn, int[] existsInSquare) {
        if (column >= 9) {
            row += 1;
            column = 0;
        }
        if (row >= 9) {
            return true;
        }
        if (board[row][column] != '.') {
            return dfs(board, row, column + 1, existsInRow, existsInColumn, existsInSquare);
        }
        int squareNum = (row / 3) * 3 + column / 3;
        for (int i = 1; i <= 9; i++) {
            if ((existsInRow[row] & (1 << i)) == 0 && (existsInColumn[column] & (1 << i)) == 0
                    && (existsInSquare[squareNum] & (1 << i)) == 0) {
                existsInRow[row] |= 1 << i;
                existsInColumn[column] |= 1 << i;
                existsInSquare[squareNum] |= 1 << i;
                board[row][column] = (char) (i + '0');
                if (dfs(board, row, column + 1, existsInRow, existsInColumn, existsInSquare)) {
                    return true;
                }
                existsInRow[row] &= ~(1 << i);
                existsInColumn[column] &= ~(1 << i);
                existsInSquare[squareNum] &= ~(1 << i);
                board[row][column] = '.';
            }
        }
        return false;
    }

    private void setNumber(int i, int j, int num, int[] existsInRow, int[] existsInColumn, int[] existsInSquare, boolean status) {
        int squareNum = (i / 3) * 3 + j / 3;
        if (status) {
            existsInRow[i] |= 1 << num;
            existsInColumn[j] |= 1 << num;
            existsInSquare[squareNum] |= 1 << num;
        } else {
            existsInRow[i] &= ~(1 << num);
            existsInColumn[j] &= ~(1 << num);
            existsInSquare[squareNum] &= ~(1 << num);
        }
    }
}