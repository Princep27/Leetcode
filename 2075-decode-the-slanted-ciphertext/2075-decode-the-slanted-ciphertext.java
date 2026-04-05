class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder ans = new StringBuilder(encodedText.length());

        int row = 0, col = 0, n = rows, m = (encodedText.length() + 1)/rows;
        while(col < m){
            int pos = row*m + col;

            while((pos) < encodedText.length()){
                ans.append(encodedText.charAt(pos));
                pos += m + 1;
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