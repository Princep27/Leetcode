class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder ans = new StringBuilder("");

        int row = 0, col = 0, n = rows, m = (encodedText.length() + 1)/rows;
        while(col < m){
            int i = row, j = col;
            while((i*m + j) < encodedText.length()){
                ans.append(encodedText.charAt(i*m + j));
                ++i; ++j;
            }
            ++col;
        }

        int len = ans.length();
        while(len > 0 && ans.charAt(len-1) == ' '){
            ans.deleteCharAt(len-1);
            --len;
        }
        
        return ans.toString();
    }
}