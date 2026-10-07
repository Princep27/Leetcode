class Solution {
    void solve(HashSet<String> set,String s,StringBuilder curStr,int i,int open,int removeCnt){

        if(i == s.length()){
            if(open == 0 && removeCnt == 0)
                set.add(curStr.toString());
            return;
        }

        else if(s.charAt(i) == '('){

            if(removeCnt > 0){
                //not remove -> pick
                curStr.append('(');
                solve(set,s,curStr,i+1,open+1,removeCnt);
                curStr.deleteCharAt(curStr.length()-1);

                //remove -> not pick
                solve(set,s,curStr,i+1,open,removeCnt-1);
            }

            else{
                //only not remove case possible
                curStr.append('(');
                solve(set,s,curStr,i+1,open+1,removeCnt);
                curStr.deleteCharAt(curStr.length()-1);
            }
        }
        
        else if(s.charAt(i) == ')'){

            if(removeCnt > 0){
                //not remove
                if(open > 0){
                    curStr.append(')');
                    solve(set,s,curStr,i+1,open-1,removeCnt);
                    curStr.deleteCharAt(curStr.length()-1);
                }
                
                //remove
                solve(set,s,curStr,i+1,open,removeCnt-1);
            }else{
                //not remove
                if(open > 0){
                    curStr.append(')');
                    solve(set,s,curStr,i+1,open-1,removeCnt);
                    curStr.deleteCharAt(curStr.length()-1);
                }
                
            }
            
        }

        else{

            curStr.append(s.charAt(i));
            solve(set,s,curStr,i+1,open,removeCnt);
            curStr.deleteCharAt(curStr.length()-1);

        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        StringBuilder curStr = new StringBuilder();
        int open = 0,removeCnt = 0;
        for(int i=0;i<n;++i){
            if(s.charAt(i) == '('){
                ++open;
            }
            else if(s.charAt(i) == ')'){
                if(open == 0) ++removeCnt;
                else --open;
            }
        }
        removeCnt += open;

        solve(set,s,curStr,0,0,removeCnt);
        for(String ss : set) ans.add(ss);

        return ans;
    }
}