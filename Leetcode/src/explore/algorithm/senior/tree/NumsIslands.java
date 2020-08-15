package explore.algorithm.senior.tree;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-26 10:17
 **/
public class NumsIslands {
    public int numIslands(char[][] grid) {
        int res = 0 ;
        for(int i = 0 ; i < grid.length ; i ++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == '1')
                {
                    res ++ ;
                    dfs(i,j,grid) ;
                }
            }
        }
        return res ;
    }
    private void dfs(int i, int j, char[][] grid)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return ;
        }
        grid[i][j] = '0' ;
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}
