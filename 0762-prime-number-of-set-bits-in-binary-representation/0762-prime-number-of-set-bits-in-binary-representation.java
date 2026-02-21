class Solution {

    static boolean isPrime(int num){
        if(num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || 
        num == 13 || num == 17 || num == 19 || num == 23 || num == 29 
        || num == 31) return true;
        else return false;
    }

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int num=left;num <= right; ++num){
            int tmp = num,cnt = 0;
            while(tmp > 0){
                if(tmp % 2 == 1) ++cnt;
                tmp /= 2;
            }
            if(isPrime(cnt)) ++ans;
        }   
        return ans;
    }
}