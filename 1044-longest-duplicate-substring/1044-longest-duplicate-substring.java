class Solution {

    private static final long MOD = (1L << 31) - 1;
    private static final long BASE = 26;

    private String check(String s, int len) {
        int n = s.length();
        if (len == 0) return "";

        long hash = 0, power = 1;

        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + (s.charAt(i) - 'a')) % MOD;
            power = (power * BASE) % MOD;
        }

        Map<Long, List<Integer>> map = new HashMap<>();
        map.put(hash, new ArrayList<>());
        map.get(hash).add(0);

        for (int i = len; i < n; i++) {

            hash = (hash * BASE
                    + MOD
                    - ((s.charAt(i - len) - 'a') * power) % MOD
                    + (s.charAt(i) - 'a')) % MOD;

            int start = i - len + 1;

            if (map.containsKey(hash)) {

                for (int prevStart : map.get(hash)) {
                    if(s.substring(prevStart,prevStart+len).equals(s.substring(start,start+len))){
                        return s.substring(start,start+len);
                    }
                }
            }

            if(!map.containsKey(hash)) map.put(hash,new ArrayList<>());
            map.get(hash).add(start);
        }

        return "";
    }

    public String longestDupSubstring(String s) {
        int n = s.length();

        int l = 1, r = n - 1;
        String ans = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            String res = check(s, mid);

            if (!res.isEmpty()) {
                ans = res;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}