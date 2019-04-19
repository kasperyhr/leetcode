class NumArray {
    SegmentTree root;
    public NumArray(int[] nums) {
        root = build(0, nums.length - 1, nums);
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private SegmentTree build(int start, int end, int[] nums){
        if(start > end)
            return null;
        SegmentTree res = new SegmentTree(start, end);
        
        if(start == end){
            res.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            res.left = build(start, mid, nums);
            res.right = build(mid + 1, end, nums);
            res.sum = res.left.sum + res.right.sum;
        }
        
        return res;
    }
    
    private void update(SegmentTree root, int i, int val){
        if(root.start == root.end){
            if(root.start == i){
                root.sum = val;
            }
            return;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        
        if(i <= mid){
            update(root.left, i, val);
        }
        if(mid + 1 <= i){
            update(root.right, i, val);
        }
        
        root.sum = root.left.sum + root.right.sum;
    }
    
    private int sumRange(SegmentTree root, int start, int end){
        if(start > end)
            return 0;
        if(start <= root.start && root.end <= end){
            return root.sum;
        }
        int sum = 0;
        int mid = root.start + (root.end - root.start) / 2;
        if(start <= mid){
            sum += sumRange(root.left, start, end);
        }
        if(mid + 1 <= end){
            sum += sumRange(root.right, start, end);
        }
        
        return sum;
    }
}

class SegmentTree{
    int start;
    int end;
    int sum;
    SegmentTree left, right;
    public SegmentTree(){}
    
    public SegmentTree(int s, int e){
        start = s;
        end = e;
        left = null;
        right = null;
        sum = 0;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */