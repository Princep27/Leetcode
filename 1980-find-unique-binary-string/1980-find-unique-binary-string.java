class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int maxVal = (int)Math.pow(2,n) - 1;
        String ans = "";
        HashSet<Integer> st = new HashSet<>();

        for(int i=0;i<n;++i){
            int val = 0;
            for(int j=0;j<n;++j){
                val *= 2;
                if(nums[i].charAt(j) == '1') ++val;
            }
            st.add(val);
        }

        for(int i=0;i<=maxVal;++i){
            if(!st.contains(i)){
                while(i > 0){
                    if(i%2 == 1) ans = '1' + ans;
                    else  ans = '0' + ans;
                    i /= 2;
                }
                break;
            }
        }

        while(ans.length() < n) ans = '0' + ans;
        return ans;
    }
}