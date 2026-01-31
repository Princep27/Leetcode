class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        boolean found = false;
        char ans = letters[0];

        for(int i=0;i<n;++i) 
        if(!found && letters[i] > target){
            found = true; ans = letters[i];
        } 
        else if(found && ans > letters[i] && letters[i] > target){
            ans = letters[i];
        } 

        return ans;
    }
}