import java.util.Arrays;

public class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    checkIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void checkIsland(char[][] grid, int row, int col) {
        grid[row][col] = ' ';
        if (row - 1 >= 0) {
            if (grid[row - 1][col] == '1')
                checkIsland(grid, row - 1, col);
        }
        if (row + 1 <= grid.length - 1) {
            if (grid[row + 1][col] == '1')
                checkIsland(grid, row + 1, col);
        }
        if (col - 1 >= 0) {
            if (grid[row][col - 1] == '1')
                checkIsland(grid, row, col - 1);
        }
        if (col + 1 <= grid[0].length - 1) {
            if (grid[row][col + 1] == '1')
                checkIsland(grid, row, col + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        System.out.println(new Solution().numIslands(grid));

        for (char[] cs : grid) {
            System.out.println(Arrays.toString(cs));
        }
    }
}