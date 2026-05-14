class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;++i){
            if(s.charAt(i) == '*') stack.removeLast();
            else stack.addLast(s.charAt(i));
        }
        while(stack.size() != 0) ans.append(stack.pollLast());
        return ans.reverse().toString();
    }
}