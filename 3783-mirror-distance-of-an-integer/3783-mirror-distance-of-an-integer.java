class Solution {
    public int mirrorDistance(int n) {
        int temp = 0,num = n;
        while(num > 0){
            temp = temp*10 + num%10;
            num /= 10;
        }
        return Math.abs(n - temp);
    }
}