class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = a.length(), m = b.length();
        int i = n-1, j = m-1,rem = 0;

        while(i >= 0 && j >= 0){
            int val1 = a.charAt(i) == '1' ? 1 : 0;
            int val2 = b.charAt(j) == '1' ? 1 : 0;
            int res = val1 + val2 + rem;
            if(res == 3){
                ans.append('1'); rem = 1;
            }else if(res == 2){
                ans.append('0'); rem = 1;
            }else if(res == 1){
                ans.append('1'); rem = 0;
            }else{
                ans.append('0');
            }
            --i; --j;
        }

        while(i >= 0){
            int val = a.charAt(i) == '1' ? 1 : 0;
            int res = val + rem;
            if(res == 3){
                ans.append('1'); rem = 1;
            }else if(res == 2){
                ans.append('0'); rem = 1;
            }else if(res == 1){
                ans.append('1'); rem = 0;
            }else{
                ans.append('0');
            }
            --i;
        }

        while(j >= 0){
            int val = b.charAt(j) == '1' ? 1 : 0;
            int res = val + rem;
            if(res == 3){
                ans.append('1'); rem = 1;
            }else if(res == 2){
                ans.append('0'); rem = 1;
            }else if(res == 1){
                ans.append('1'); rem = 0;
            }else{
                ans.append('0');
            }
            --j;
        }

        if(rem != 0) ans.append('1');
        return ans.reverse().toString();
    }
}