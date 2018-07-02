class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList();
        if(nums.length < 4)
            return ret;
        Arrays.sort(nums);
        if(nums[0] + nums[1] + nums[2] + nums[3] > target)
            return ret;
        if(nums.length >= 4 && nums[0] + nums[1] + nums[2] + nums[3] == target){
            Integer[] aa = {nums[0], nums[1], nums[2], nums[3]};
            List<Integer> a = Arrays.asList(aa);
            ret.add(a);
            return ret;
        }
        
        for(int ptr1 = 0; ptr1 < nums.length; ptr1++){
            for(int ptr2 = ptr1 + 1; ptr2 < nums.length; ptr2++){
                int ptr3 = ptr2 + 1;
                int ptr4 = nums.length - 1;
                while(ptr3 < ptr4 && ptr4 > ptr2 && ptr3 < nums.length){
                    if(nums[ptr1] + nums[ptr2] + nums[ptr3] + nums[ptr4] < target){
                        int ptr3tmp = ptr3 + 1;
                        while(ptr3tmp < nums.length && nums[ptr3tmp] == nums[ptr3])
                            ptr3tmp += 1;
                        ptr3 = ptr3tmp;
                    } else if(nums[ptr1] + nums[ptr2] + nums[ptr3] + nums[ptr4] > target){
                        int ptr4tmp = ptr4 - 1;
                        while(ptr4tmp > ptr2 && nums[ptr4tmp] == nums[ptr4])
                            ptr4tmp -= 1;
                        ptr4 = ptr4tmp;
                    } else {
                        Integer[] aa = {nums[ptr1], nums[ptr2], nums[ptr3], nums[ptr4]};
                        List<Integer> a = Arrays.asList(aa);
                        ret.add(a);
                        int ptr3tmp = ptr3 + 1;
                        while(ptr3tmp < nums.length && nums[ptr3tmp] == nums[ptr3])
                            ptr3tmp += 1;
                        ptr3 = ptr3tmp;
                        int ptr4tmp = ptr4 - 1;
                        while(ptr4tmp > ptr2 && nums[ptr4tmp] == nums[ptr4])
                            ptr4tmp -= 1;
                        ptr4 = ptr4tmp;    
                    }
                }
                int ptr2tmp = ptr2 + 1;
                while(ptr2tmp < nums.length && nums[ptr2] == nums[ptr2tmp])
                    ptr2tmp += 1;
                ptr2 = ptr2tmp - 1;
            }
            int ptr1tmp = ptr1 + 1;
            while(ptr1tmp < nums.length && nums[ptr1] == nums[ptr1tmp])
                ptr1tmp += 1;
            ptr1 = ptr1tmp - 1;
        }
        
        return ret;
    }
}