class Solution {
    char board[][];

    public void solveSudoku(char[][] board) {
        this.board = board;
        solve();
        return;
    }

    public boolean solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.')
                    continue;
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isSafe(i, j, ch)) {
                        board[i][j] = ch;
                        if(solve())
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;

    }

    public boolean isSafe(int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.')
                continue;
            else {
                if (board[row][i] == val)
                    return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.')
                continue;
            else {
                if (board[i][col] == val)
                    return false;
            }
        }

        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r + i][c + j] == val)
                    return false;
            }
        }

        return true;
    }
}
