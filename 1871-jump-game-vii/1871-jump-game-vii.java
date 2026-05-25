class Solution {
    void dfs(int curIndex,int minJump,int maxJump,boolean[] vis,TreeSet<Integer> st,int n){
        vis[curIndex] = true;

        Integer nextIndex = curIndex+minJump;
        while(true){

            nextIndex = st.ceiling(nextIndex);
            if(nextIndex == null) break;

            if((nextIndex - curIndex) <= maxJump){
                st.remove(nextIndex);
                dfs(nextIndex,minJump,maxJump,vis,st,n);
            }else{
                break;
            }

        }

    }

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) == '1') return false;
        TreeSet<Integer> st = new TreeSet<>();

        for(int i=1;i<n;++i)  
            if(s.charAt(i) == '0') st.add(i);

        boolean[] vis = new boolean[n];
        for(int i=0;i<n;++i) vis[i] = false;

        dfs(0,minJump,maxJump,vis,st,n);
        return vis[n-1];
    }
}