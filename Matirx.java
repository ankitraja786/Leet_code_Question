class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //BFS Approach
        
        if(mat == null)
            return mat;
        
        int rowLen = mat.length;
        int colLen = mat[0].length;
        
       boolean visited[][] = new boolean[rowLen][colLen];
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<rowLen; i++){
            for(int j =0; j<colLen; j++){
                if(mat[i][j] == 0)
                    q.offer(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }
        
        int directions[][] ={{1,0},{-1,0},{0,-1},{0,1}};
        int level = 0; // this is to signify that all the elements initially entered in Queue are of Level 0,
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                int cur[] = q.poll();
                for(int dir[] : directions){
                    int r = cur[0] +dir[0];
                    int c = cur[1] +dir[1];
                    //Insert in queue only the only marked wih -1 and make it true 
                    if(r>=0 && r<rowLen && c>=0 && c<colLen && mat[r][c]==-1 && !visited[r][c] ){
                        visited[r][c] = true;
                        q.offer(new int[]{r,c}); // for next time iteration with increase level 
                    }
                }
                mat[cur[0]][cur[1]] = level; //once size is over, we mark all the elements initially with level 0
                //next time level increases
            }
            level++; // after size is over, level is increased for next processing
        }
        return mat;
    }
}