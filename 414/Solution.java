class Solution {
    public int thirdMax(int[] nums) {
        Integer one = null;
        Integer two = null;
        Integer three = null;
        for(int num: nums){
            if(one == null ||num > one){
                three = two;
                two = one;
                one = num;
            } else if((two == null || num > two) && num < one){
                three = two;
                two = num;
            } else if((three == null || num > three) && two != null && num < two){
                three = num;
            }
        }
        if(three == null){
            return one;
        }
        return three;
    }
}