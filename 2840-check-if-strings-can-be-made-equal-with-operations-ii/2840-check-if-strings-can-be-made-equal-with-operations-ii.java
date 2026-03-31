import java.util.Arrays;

class Solution {
    public boolean checkStrings(String s1, String s2) {

        StringBuilder odd1 = new StringBuilder();
        StringBuilder even1 = new StringBuilder();

        for (int i = 0; i < s1.length(); i += 2)
            odd1.append(s1.charAt(i));
        for (int i = 1; i < s1.length(); i += 2)
            even1.append(s1.charAt(i));

        StringBuilder odd2 = new StringBuilder();
        StringBuilder even2 = new StringBuilder();

        for (int i = 0; i < s2.length(); i += 2)
            odd2.append(s2.charAt(i));
        for (int i = 1; i < s2.length(); i += 2)
            even2.append(s2.charAt(i));

        char[] o1 = odd1.toString().toCharArray();
        char[] e1 = even1.toString().toCharArray();
        char[] o2 = odd2.toString().toCharArray();
        char[] e2 = even2.toString().toCharArray();

        Arrays.sort(o1);
        Arrays.sort(e1);
        Arrays.sort(o2);
        Arrays.sort(e2);

        return Arrays.equals(o1, o2) && Arrays.equals(e1, e2);
    }
}