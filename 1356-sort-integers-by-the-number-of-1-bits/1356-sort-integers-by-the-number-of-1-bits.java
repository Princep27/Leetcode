class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length,cur = 0;
        int[] ans = new int[n];
        Arrays.sort(arr);
        for(int i=0;i<=32;++i){
            for(int j=0;j<n;++j){
                int num = arr[j], cnt = 0;
                while(num > 1){
                    if(num % 2 == 1) ++cnt;
                    num /= 2;
                }
                if(cnt == i){
                    ans[cur] = arr[j]; ++cur;
                }
            }
        }

        return ans;
    }
}