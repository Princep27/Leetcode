class Solution {
    
    static boolean solve(boolean[] vis,int[] arr,int index,int n){
        if(arr[index] == 0) return true;
        boolean valid = false;
        int v = index + arr[index];
        int w = index - arr[index];

        if(v < n && v >= 0 && !vis[v]){
            vis[v] = true;
            valid = valid || solve(vis,arr,v,n);
        }
        if(w < n && w >= 0 && !vis[w]){
            vis[w] = true;
            valid = valid || solve(vis,arr,w,n);
        }

        return valid;
    }

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        vis[start] = true;
        return solve(vis,arr,start,n);
    }
}