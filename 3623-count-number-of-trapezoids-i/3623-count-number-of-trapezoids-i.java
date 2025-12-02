class Solution {
    public int countTrapezoids(int[][] points) {
        long ans = 0,prev = 0,mod = 1000000007;
        int n = points.length;
        HashMap<Integer,Long> mp = new HashMap<>();
        for(int i=0;i<n;++i){
            int y = points[i][1]; 
            long cnt = mp.getOrDefault(y,(long)0);
            mp.put(y,cnt+1);
        }

        for(Integer key : mp.keySet()){
            long value = mp.get(key);
            long pairs = (value*(value-1))/2;
            ans = (ans + pairs*prev)%mod;
            prev = (prev + pairs)%mod; 
        }

        return (int)ans;
    }
}