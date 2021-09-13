lass Solution {
    public void moveZeroes(int[] nums) {
      int n = nums.length;
      int l =0; 
      int h =1;
      while(l<n && h <n){
        if(nums[l]==0 && nums[h]!=0){
          nums[l] = nums[h];
          nums[h] =0;
          l++;
          h++;
        }
        else if (nums[l]==0 && nums[h] == 0)
          h++;
        else if (nums[l]!=0){
          l++;
          h++;
        }
      }
      
        
    }
}