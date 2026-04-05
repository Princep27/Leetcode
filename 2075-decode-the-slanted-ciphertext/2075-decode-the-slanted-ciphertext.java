class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder ans = new StringBuilder(encodedText.length());

        int col = 0, n = rows, m = (encodedText.length() + 1)/rows;
        while(col < m){
            int pos = col;

            while((pos) < encodedText.length()){
                ans.append(encodedText.charAt(pos));
                pos += m + 1;
            }

            ++col;
        }

        int end = ans.length() - 1;
        while (end >= 0 && ans.charAt(end) == ' ') {
            end--;
        }
        
        return ans.substring(0, end + 1);
    }
}