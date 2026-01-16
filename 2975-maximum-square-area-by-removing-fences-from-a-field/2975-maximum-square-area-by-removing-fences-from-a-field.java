class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        HashSet<Integer> mp = new HashSet<>();
        Arrays.sort(hFences); 
        Arrays.sort(vFences);
        long ans = -1, mod = 1000000007;
        
        mp.add(m-1);
        for(int i=0;i<hFences.length;++i){
            mp.add(hFences[i]-1);
            mp.add(m-hFences[i]);
        }

        for(int i=0;i<hFences.length;++i){ 
            for(int j=i+1;j<hFences.length;++j){
                mp.add(hFences[j]-hFences[i]);
            }
        }

        for(int i=0;i<vFences.length;++i){
            int tmp = (vFences[i]-1);
            if(mp.contains(tmp)) ans = Math.max(ans, (long)tmp*(long)tmp);
            
            tmp = n-vFences[i];
            if(mp.contains(tmp)) ans = Math.max(ans, (long)tmp*(long)tmp);
        }

        for(int i=0;i<vFences.length;++i){ 
            for(int j=i+1;j<vFences.length;++j){
                int tmp = vFences[j]-vFences[i];
                if(mp.contains(tmp)) ans = Math.max(ans, (long)tmp*(long)tmp);
            }
        }

        int tmp = n-1;
        if(mp.contains(tmp)) ans = Math.max(ans, (long)tmp*(long)tmp);
        
        return (int)(ans%mod);
    }
}