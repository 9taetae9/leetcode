class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            if(arr[current] == 0) return true;

            int left = current - arr[current];
            int right = current + arr[current];

            if(left >= 0 && !visited[left]){
                queue.offer(left);
                visited[left] = true;
            }

            if(right < n && !visited[right]){
                queue.offer(right);
                visited[right] = true;
            }
        }

        return false;
    }
}