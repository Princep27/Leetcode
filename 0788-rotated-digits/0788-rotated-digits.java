class Solution {
    public int rotatedDigits(int n) {

        int ans = 0;
        for(int i=1;i<=n;++i){

            int num = i;
            boolean rotated = false,valid = true;

            while(num > 0){
                int rem = num%10; num /= 10;
                if(rem == 2 || rem == 5 || rem == 6 || rem == 9) rotated = true;
                else if(rem == 0 || rem == 1 || rem == 8) continue;
                else valid = false;
            }

            if(rotated && valid) ++ans;
        }

        return ans;
    }
}