class Solution {

    boolean valid(int[][] tasks,long val,int n){
        for(int i=0;i<n;++i){
            if(tasks[i][1] > val) return false;
            else val -= tasks[i][0];
            if(val < 0) return false;
        }
        return true;
    }

    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        long ans = Integer.MAX_VALUE;
        Arrays.sort(tasks,(b,a)->Integer.compare(a[1]-a[0],b[1]-b[0]));
        long sum = 0;
        for(int i=0;i<n;++i) sum += tasks[i][0];

        long l = sum, r = Integer.MAX_VALUE;
        while(l <= r){
            
            long mid = l + (r-l)/2;
            if(valid(tasks,mid,n)){
                System.out.println(l + " " + r + " " + mid);
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            } 
        }

        return (int)ans;
    }
}