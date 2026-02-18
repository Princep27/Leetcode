class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;
        while(n > 0){
            if(n%2 == prev) return false;
            else{
                prev = n%2;
                n /= 2;        
            }
        }
        return true;
    }
}