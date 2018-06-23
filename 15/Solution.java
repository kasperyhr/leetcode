import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        if(nums.length < 3)
            return ret;
        Arrays.sort(nums);
        if(nums[0] + nums[1] + nums[2] > 0)
            return ret;
        if(nums.length >= 3 && nums[0] + nums[1] + nums[2] == 0){
            Integer[] aa = {nums[0], nums[1], nums[2]};
            List<Integer> a = Arrays.asList(aa);
            ret.add(a);
            return ret;
        }
        for(int i = 0; i < nums.length; i++){
            int pt1 = i + 1;
            int pt2 = nums.length - 1;
            while(pt1 < pt2 && pt2 > i && pt1 < nums.length){
                if(nums[pt1] + nums[pt2] + nums[i] < 0)
                    pt1 += 1;
                else if(nums[pt1] + nums[pt2] + nums[i] > 0)
                    pt2 -= 1;
                else{
                    Integer[] aa = {nums[pt1], nums[pt2], nums[i]};
                    List<Integer> a = Arrays.asList(aa);
                    ret.add(a);
                    int pt3 = pt1 + 1;
                    while(pt3 < nums.length && nums[pt3] == nums[pt1])
                        pt3 += 1;
                    int pt4 = pt2 - 1;
                    while(pt4 > i && nums[pt4] == nums[pt2])
                        pt4 -= 1;
                    pt1 = pt3;
                    pt2 = pt4;
                }       
            }
            int j = i + 1;
            while(j < nums.length && nums[i] == nums[j])
                j += 1;
            i = j - 1;
        }
        return ret;
    }
    
    
}