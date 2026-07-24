class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int ans = 0,max = -1;
        Arrays.sort(intervals,(a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(b[1],a[1]);
        });
        for(int i=0;i<intervals.length;++i){
            if(intervals[i][1] > max){
                ++ans; max = intervals[i][1];
            }
        }
        return ans;
    }
}