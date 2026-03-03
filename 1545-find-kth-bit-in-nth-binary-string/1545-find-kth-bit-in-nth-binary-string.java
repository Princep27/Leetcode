class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder();
        str.append('0');

        for(int i=2;i<=k;++i){
            str.append('1');
            int j = i-2;

            while(j >= 0 && i < k){
                str.append(str.charAt(j) == '1' ? '0' : '1');
                --j; ++i;
            }
        }

        return str.charAt(k-1);
    }
}