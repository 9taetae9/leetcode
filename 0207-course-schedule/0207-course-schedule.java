class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        
        //prerequisites[1] => prerequisites[0]
        for(int[] p : prerequisites){
            indegree[p[0]]++;
            adjList.get(p[1]).add(p[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }


        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int node = q.poll();
            visited.add(node);
            for(int i : adjList.get(node)){
                if(visited.contains(i)) continue;
                if(--indegree[i] == 0){
                    q.offer(i);
                }
            }
        }

        return visited.size() == numCourses;
        
    }
}