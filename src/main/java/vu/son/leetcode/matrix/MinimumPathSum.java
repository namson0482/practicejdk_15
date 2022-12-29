package vu.son.leetcode.matrix;


/**
 * @author Son Vu
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 */
public class MinimumPathSum {

    int[][] directions = new int[][] {{0, 1}, {1, 0}};
    int minValue = 0;

    public void pathSum(int [][]grid, int [][]visited, int row, int col, int sumValue) {
        if(row > grid.length - 1 || col > grid[0].length - 1) {
            return;
        }

        if(row == grid.length - 1 && col == grid[0].length - 1) {
            if(minValue == 0) {
                minValue = sumValue;
            } else {
                if(sumValue < minValue) {
                    minValue = sumValue;
                }
            }
        }

        for(int []direction: directions) {

            if(row + direction[0] > visited.length - 1 || col + direction[1] > visited[0].length - 1 || visited[row + direction[0]][col + direction[1]] == 101) {
                continue;
            }
            row = row + direction[0];
            col = col + direction[1];
            visited[row][col] = 101;
            sumValue += grid[row][col];

            pathSum(grid, visited, row, col, sumValue);

            visited[row][col] = 0;
            sumValue -= grid[row][col];
            row = row - direction[0];
            col = col - direction[1];


        }

    }

    public int minPathSumTemp(int [][]grid) {

        int[][] visited = new int[grid.length][grid[0].length];
        visited[0][0] = 101;
        pathSum(grid, visited, 0, 0, grid[0][0]);

        return minValue;
    }

    public int minPathSum(int[][] grid) {

        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for(int i=1; i<grid.length; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int j=1; j<grid[0].length; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i=1; i<grid.length; i++) {

            for(int j=1; j<grid[0].length; j++){

                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];

            }

        }

        return dp[grid.length-1][grid[0].length-1];

    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                };
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(mat));
    }
}
