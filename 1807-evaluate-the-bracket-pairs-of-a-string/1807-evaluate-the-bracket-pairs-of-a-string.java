class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = knowledge.size(), m = s.length();
        StringBuilder ans = new StringBuilder();
        TreeMap<String,String> mp = new TreeMap<>();
        for(int i=0;i<n;++i){
            mp.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        for(int i=0;i<m;++i){
            if(s.charAt(i) == '('){
                ++i;
                StringBuilder key = new StringBuilder();
                while(s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    ++i;
                }
                if(mp.containsKey(key.toString())) ans.append(mp.get(key.toString()));
                else ans.append('?');
            }else{
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}