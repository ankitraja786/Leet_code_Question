class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int ans = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;
        
        for(int i=0; i<nums.length;i++){
            currSum += nums[i];
            
            while(currSum>= target){
                ans = Math.min(ans,i-left+1);
                
                currSum-= nums[left++];
            }
        }
        
        return (ans!=Integer.MAX_VALUE)? ans : 0;
        
    }