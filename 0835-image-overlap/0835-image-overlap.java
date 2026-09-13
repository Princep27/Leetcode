class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        ArrayList<int[]> arr1 = new ArrayList<>();
        ArrayList<int[]> arr2 = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(img1[i][j] == 1) arr1.add(new int[]{i,j});
                if(img2[i][j] == 1) arr2.add(new int[]{i,j});
            }
        }

        int ans = 0;
        for(int i=0;i<arr1.size();++i){
            int r1 = arr1.get(i)[0];
            int c1 = arr1.get(i)[1];
            
            for(int j=0;j<arr2.size();++j){
                int r2 = arr2.get(j)[0];
                int c2 = arr2.get(j)[1];

                int dr = r2 - r1;
                int dc = c2 - c1;

                int key = dr*100 + dc;
                mp.put(key, mp.getOrDefault(key,0)+1);
                ans = Math.max(ans, mp.get(key));
            }
        }

        return ans;
    }
}