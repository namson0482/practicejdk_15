package vu.son.leetcode.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NQueen {
    private int size;
    private List<List<String>> solutions = new ArrayList<List<String>>();

    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }

    // Making use of a helper function to get the
    // solutions in the correct output format
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        return board;
    }

    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state) {
        // Base case - N queens have been placed
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }

        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            // If the queen is not placeable
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }

            // "Add" the queen to the board
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';

            // Move on to the next row with the updated board state
            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }


    List<List<String>> solveNQueensTemp(int n) {
        List<List<String>> result = new ArrayList<>();
        String[] nQueens = new String[n];
        char[] init = new char[n];
        Arrays.fill(init, '.');
        Arrays.fill(nQueens, String.valueOf(Arrays.copyOf(init, n)));
        search(n, 0, nQueens, result);
        return result;
    }


    private void search(int n, int row, String[] nQueens, List<List<String>> result) {
        if (row == n) {
            result.add(new ArrayList<String>(Arrays.asList(nQueens)));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(nQueens, row, col, n)) {
                char[] chars;
                chars = nQueens[row].toCharArray();
                chars[col] = 'Q';
                nQueens[row] = String.valueOf(chars);

                // nQueens[row][col] = 'Q';
                search(n, row + 1, nQueens, result);
                chars = nQueens[row].toCharArray();
                chars[col] = '.';
                nQueens[row] = String.valueOf(chars);
                // nQueens[row][col] = '.';
            }
        }
    }

    private boolean isValid(String[] nQueens, int row, int col, int n) {
        char[] chars;
        for (int i = 0; i < row; i++) {
            chars = nQueens[i].toCharArray();
            if (chars[col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            chars = nQueens[i].toCharArray();
            if (chars[j] == 'Q') {
                return false;
            }
        }

        for (int  i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            chars = nQueens[i].toCharArray();
            if (chars[j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List list = nQueen.solveNQueens(4);
        list.forEach(System.out::println);
    }
}
