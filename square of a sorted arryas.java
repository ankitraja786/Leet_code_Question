class Solution {
    public int[] sortedSquares(int[] nums) {
        
      int ans[] = new int [nums.length];
      
      int i =0;
      int j = nums.length-1;
      int x = nums.length-1;
      
      while(x>=0){
        if(nums[i]*nums[i] > nums[j]* nums[j]) {
          ans[x]= nums[i]*nums[i];
          i++;
        }
        else
        {
          ans[x] = nums[j]*nums[j];
          j--;
        }
        x--;
        }
      return ans;
    }
}