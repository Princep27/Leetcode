class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<String,Integer> mp = new HashMap<>();
        int ans = 0;
        for(int i=0;i<obstacles.length;++i){
            mp.put(obstacles[i][0] + " " + obstacles[i][1],1);
        }

        int direction = 0;
        int pos_x = 0, pos_y = 0;
        int[] x = new int[4];
        int[] y = new int[4];

        x[0] = 0; y[0] = 1;
        x[1] = 1; y[1] = 0;
        x[2] = 0; y[2] = -1;
        x[3] = -1; y[3] = 0;
        
        for(int op : commands){

            if(op == -1){
                ++direction;
                direction = (direction+4)%4;
            }
            else if(op == -2){
                --direction;
                direction = (direction+4)%4;
            }
            else{
                int cnt = 0, index = direction;
                int xx = pos_x,yy = pos_y;
                while(cnt < op){
                    xx = xx + x[index];
                    yy = yy + y[index];
                    if(mp.containsKey(xx + " " + yy)) break;
                    else{
                        ++cnt;
                        pos_x = xx; pos_y = yy;
                        ans = Math.max(ans, xx*xx + yy*yy);
                    }
                }
            }

        }

        return ans;
    }
}