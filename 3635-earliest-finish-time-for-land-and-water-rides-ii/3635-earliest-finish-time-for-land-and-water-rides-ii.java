class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int n = landStartTime.length, m = waterStartTime.length;
        int landMinEnd = Integer.MAX_VALUE;
        int waterMinEnd = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;++i) landMinEnd = Math.min(landStartTime[i] + landDuration[i], landMinEnd);
        for(int i=0;i<m;++i) waterMinEnd = Math.min(waterStartTime[i] + waterDuration[i], waterMinEnd);

        for(int i=0;i<m;++i){
            ans = Math.min(ans, (waterStartTime[i] >= landMinEnd ? waterStartTime[i] + waterDuration[i] : landMinEnd + waterDuration[i]));
        }

        for(int i=0;i<n;++i){
            ans = Math.min(ans, (landStartTime[i] >= waterMinEnd ? landStartTime[i] + landDuration[i] : waterMinEnd + landDuration[i]));
        }
    
        return ans;
    }
}