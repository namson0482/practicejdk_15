package vu.son.leetcode.matrix;

public class UniquePath {

    int[][] directions = {{0, 1}, {1, 0}};

    public int uniquePathsTemp(int m, int n) {
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            path[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }

    public int countUniquePath(int visited[][], int row, int col) {


        if (row > visited.length -1 || col > visited[0].length - 1) {
            return 0;
        }



        if(row == visited.length - 1 && col == visited[0].length - 1) {
            return 1;
        }

        int total = 0;
        for(int []direction: directions) {

            if(row + direction[0] > visited.length - 1 || col + direction[1] > visited[0].length - 1 || visited[row + direction[0]][col + direction[1]] == 101) {
                continue;
            }
            row = row + direction[0];
            col = col + direction[1];
            visited[row][col] = 101;

            total += countUniquePath(visited, row, col);

            visited[row][col] = 0;
            row = row - direction[0];
            col = col - direction[1];

        }

        return total;
    }

    public int uniquePaths(int m, int n) {

        int[][] visited = new int[m][n];
        return countUniquePath(visited, 0, 0);
    }

    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        System.out.println(uniquePath.uniquePathsTemp(3, 2));
    }
}
