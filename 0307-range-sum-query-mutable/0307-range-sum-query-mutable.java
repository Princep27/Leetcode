class NumArray {

    int[] seg;
    int len;

    private void build(int[] nums,int l,int r,int t_index){
        if(l == r)
            seg[t_index] = nums[l];
        else{
            int mid = (l+r)/2;
            build(nums, l, mid, t_index*2 +1);
            build(nums, mid+1, r, t_index*2 + 2);
            seg[t_index] = seg[t_index*2 + 1] + seg[t_index*2 + 2];
        }
    }

    private void update(int n_index,int val,int l,int r,int t_index){
        if(l == r)
            seg[t_index] = val;
        else{
            int mid = (l+r)/2;
            if(n_index <= mid && n_index >= l){
                update(n_index,val,l,mid,t_index*2 + 1);
            }else{
                update(n_index,val,mid+1,r,t_index*2 + 2);
            }
            seg[t_index] = seg[t_index*2+1] + seg[t_index*2+2];
        }
    }

    private int query(int l_range,int r_range,int l,int r,int t_index){
        if(l >= l_range && r <= r_range)
            return seg[t_index];
        else if(l > r_range || r < l_range) 
            return 0;
        else{
            int mid = (l+r)/2;
            int l_res = query(l_range, r_range,l,mid, t_index*2+1);
            int r_res = query(l_range, r_range,mid+1, r, t_index*2+2);
            return l_res + r_res;
        }
    }

    public NumArray(int[] nums) {
        int n = nums.length;
        len = n;
        seg = new int[n*4];
        build(nums,0,n-1,0);
    }
    
    public void update(int index, int val) {
        update(index,val,0,len-1,0);
    }
    
    public int sumRange(int left, int right) {
        return query(left,right,0,len-1,0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */