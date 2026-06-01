class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long cur = mass;
        for(int i=0;i<asteroids.length;++i){
            if(cur < asteroids[i]) return false;
            cur += (long)asteroids[i];
        }
        return true;
    }
}