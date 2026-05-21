class Solution {

    class Trie{
        Trie[] next = new Trie[11];
        Trie(){
            for(int i=0;i<10;++i) next[i] = null;
        }
    }

    Trie root = new Trie();

    void add(int num){
        Trie cur = root;
        String str = String.valueOf(num);
        for(char ch :  str.toCharArray()){
            int index = ch - '0';
            if(cur.next[index] == null) cur.next[index] = new Trie();
            cur = cur.next[index];
        }
    }

    int commonLen(int num){
        Trie cur = root;
        String str = String.valueOf(num);
        int len = 0;
        for(char ch :  str.toCharArray()){
            int index = ch - '0';
            if(cur.next[index] == null) return len;
            else{
                cur = cur.next[index]; ++len;
            }
        }
        return len;
    }


    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        for(int i=0;i<arr2.length;++i) add(arr2[i]);
        for(int i=0;i<arr1.length;++i) ans = Math.max(ans, commonLen(arr1[i]));
        return ans;
    }
}