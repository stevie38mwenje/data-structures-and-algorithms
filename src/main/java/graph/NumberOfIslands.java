package graph;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;

        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;
        int nums_islands = 0;


        for (int r = 0;r<numberOfRows;r++){
            for(int c=0;c<numberOfColumns;c++){
                if(grid[r][c]=='1'){
                    nums_islands++;
                    dfs(grid,r,c);
                }
            }
        }

        return nums_islands;

    }

    private void dfs(char[][] grid, int r, int c) {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';

        dfs(grid, r - 1, c);// visit north cell
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
