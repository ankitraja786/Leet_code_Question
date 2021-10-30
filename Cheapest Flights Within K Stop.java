ArrayList<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < flights.length; i++) 
            graph[flights[i][0]].add(new int[]{flights[i][1], flights[i][2]});
        
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.offer(new int[]{src, 0, 0}); //int[0]->node val, int[1]->weight, int[2]->stops covered so far
    
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currSrc = curr[0];
            int currWt = curr[1];
            int currK = curr[2];
            
            if(currSrc == dst) return currWt;
            
            //to avoid TLE
            if(currK > k || (visited[currSrc]!= -1 && visited[currSrc] < currK)) continue;
            
            visited[currSrc] = currK;
            
            for(int[] e : graph[currSrc]) {
                queue.offer(new int[]{e[0], currWt + e[1], currK + 1});
            }
        }
        
        return -1;
    }