class Solution {

    class Trie{
        Trie[] next = new Trie[26];
        int len;
        int ansIndex;
        Trie(){
            for(int i=0;i<26;++i) next[i] = null;
            len = 10000;
            ansIndex = -1;
        }
    }

    Trie root = new Trie();

    void add(String word,int pos){
        Trie cur = root;
        if(word.length() < cur.len){
            cur.ansIndex = pos;
            cur.len = word.length();
        }

        for(int i=word.length()-1;i>=0;--i){
            int index = word.charAt(i) - 'a';
            if(cur.next[index] == null)
                cur.next[index] = new Trie();
            
            cur = cur.next[index];
            if(word.length() < cur.len){
                cur.len = word.length();
                cur.ansIndex = pos; 
            }      
        }
    }

    int find(String word){
        Trie cur = root;
        int ans = cur.ansIndex;

        for(int i=word.length()-1;i>=0;--i){
            int index = word.charAt(i) - 'a';
            if(cur.next[index] == null) break;
            cur = cur.next[index];
            ans = cur.ansIndex;
        }
        return ans;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        for(int i=0;i<wordsContainer.length;++i){
            add(wordsContainer[i],i);
        }

        int[] ans = new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;++i){
            ans[i] = find(wordsQuery[i]);
        }

        return ans;
    }
}