class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        Map<Long, Integer> abc = new HashMap<>();
        Map<Long, Integer> ab = new HashMap<>();
        Map<Long, Integer> bc = new HashMap<>();
        Map<Long, Integer> ac = new HashMap<>();
        
        
        long a = 0, b = 0, c = 0;
        int cura = 0, curb = 0, curc = 0;

        abc.put(0L, -1);
        ab.put(0L, -1);
        bc.put(0L, -1);
        ac.put(0L, -1);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                a++; ++cura; curb = curc = 0;
            } else if (ch == 'b') {
                b++; ++curb; cura = curc = 0;
            } else { 
                c++; ++curc; cura = curb = 0;
            }

            long diffAB = a - b;
            long diffBC = b - c;
            long diffAC = a - c;

            long keyABC = diffAB + 1000000L * diffBC;
            long keyAB = diffAB + 1000000L*c;
            long keyBC = diffBC + 1000000L*a;
            long keyAC = diffAC + 1000000L*b;
            


            if (abc.containsKey(keyABC)) {
                ans = Math.max(ans, i - abc.get(keyABC));
            } else {
                abc.put(keyABC, i);
            }

            
            if (ab.containsKey(keyAB)) {
                ans = Math.max(ans, i - ab.get(keyAB));
            } else {
                ab.put(keyAB, i);
            }

            if (bc.containsKey(keyBC)) {
                ans = Math.max(ans, i - bc.get(keyBC));
            } else {
                bc.put(keyBC, i);
            }


            if (ac.containsKey(keyAC)) {
                ans = Math.max(ans, i - ac.get(keyAC));
            } else {
                ac.put(keyAC, i);
            }

            ans = Math.max(ans, Math.max(cura, Math.max(curb,curc)));

        }

        

        return ans;
    }
}