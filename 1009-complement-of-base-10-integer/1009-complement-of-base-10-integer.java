class Solution {
    public int bitwiseComplement(int n) {
        int ans = 0,mul = 1;
        if(n == 0) return 1;
        while(n > 0){
            if(n%2 == 0) ans = ans + mul;
            n = n/2; mul *= 2;
        }
        return ans;
    }
}

//10. ->  1010