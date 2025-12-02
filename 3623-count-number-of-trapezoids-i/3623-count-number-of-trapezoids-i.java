class Solution {
    public int countTrapezoids(int[][] points) {
        long ans = 0,prev = 0,mod = 1000000007;
        int n = points.length;
        TreeMap<Integer,Long> mp = new TreeMap<>();
        for(int i=0;i<n;++i){
            int x = points[i][0], y = points[i][1]; long cnt = 0;
            if(mp.containsKey(y)) cnt = mp.get(y);
            mp.put(y,cnt+1);
        }

        for(Integer key : mp.keySet()){
            long value = mp.get(key);
            long pairs = (value*(value-1))/2;
            ans += pairs*prev; ans %= mod;
            prev += pairs; prev %= mod;
        }

        return (int)ans;
    }
}