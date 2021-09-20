class Solution {
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
      
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]==2){
                    dfs(i,j,grid,2);
                }
            }
        }
        
        int result=2;
        
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
             result = Math.max(result,grid[i][j]);
            }
        }
        return result-2;
    }
    
    
    public void dfs(int x, int y,int[][] grid,int time){
        int m = grid.length;
        int n = grid[0].length;
        
        if(!isValid(x,y,m,n) || grid[x][y]==0 || (1<grid[x][y] && grid[x][y] <time) ){
            return;
        }
        
        grid[x][y]=time;
        
        for(int[] direction : directions){
            dfs(x+direction[0], y+direction[1],grid,time+1);
        }
        return ;
    }
    
    public boolean isValid(int x, int y, int m, int n){
        if(x<0 || y<0 || x>=m || y>=n){
            return false;
        }
        return true;
    }
    
}