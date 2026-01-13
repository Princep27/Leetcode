class Solution {

    static double find(int[][] squares,double mid){
        double sum = 0;
        for(int i=0;i<squares.length;++i){
            double l = squares[i][1], r = squares[i][1] + squares[i][2];
            if(l < mid){
                sum += (squares[i][2])*(Math.min(r,mid) - l);
            }
        }
        return sum;
    }

    public double separateSquares(int[][] squares) {
        double left = 0, right = 1000000001;
        double total = 0,ans = 0;
        int n = squares.length;

        for(int i=0;i<n;++i) total += (long)squares[i][2]*(long)squares[i][2];
        total /= 2;
        
        while(right - left >= 0.00001){
            double mid = (left + right)/2;
            double area = find(squares,mid);

            if(area >= total){
                right = mid;
            }else{
                left = mid;
            }

            ans = mid;
        }

        return ans;
    }
}