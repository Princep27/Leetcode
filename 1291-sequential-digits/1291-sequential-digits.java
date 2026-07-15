class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int len = 2;
        int add = 11;
        int num = 12;
        List<Integer> ans = new ArrayList<>();
        while(num <= high){

            for(int j=1;j<=10-len;++j){
                if(num <= high && num >= low) ans.add(num);
                num += add;
            }

            ++len;
            num = 0;
            for(int j=1;j<=len;++j) num = num*10 + j;
            add = add*10 + 1;
        }

        return ans;
    }
}