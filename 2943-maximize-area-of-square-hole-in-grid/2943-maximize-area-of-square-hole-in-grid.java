class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxRows = 0,cur = 0,prev = -1;
        for(int i=0;i<hBars.length;++i){
            if(hBars[i] == n+2 || hBars[i] == 1) continue;
            else if(prev+1 == hBars[i]) ++cur;
            else cur = 1;
            maxRows = Math.max(maxRows,cur); prev = hBars[i];
        }

        int maxCols = 0; cur = 0; prev = -1;
        for(int i=0;i<vBars.length;++i){
            if(vBars[i] == m+2 || vBars[i] == 1) continue;
            else if(prev+1 == vBars[i]) ++cur;
            else cur = 1;
            maxCols = Math.max(maxCols,cur); prev = vBars[i];
        }

        int side =  Math.min(maxRows,maxCols);
        return (side+1)*(side+1);
    }
}