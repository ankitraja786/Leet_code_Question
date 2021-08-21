class Solution 
{
    int[] input;
    int tar;
    
    public boolean search(int[] nums, int target) 
    {
        int index = 0;
        input = nums;
        tar = target;
        
        for(int i = 0; i <= nums.length - 2 ; i++)
            if(nums[i] > nums[i+1]){
                index = i;
                break;
            }
        
        return (binarySearch(0, index) || binarySearch(index + 1, nums.length - 1)); 
    }
    
    public boolean binarySearch(int start, int end){
        if(start <= end){
            int mid = start +(end - start) / 2;
            
            if(input[mid] == tar) return true;
            
            else if(start == end) return false;
            
            else if(input[mid] >= tar) 
                return binarySearch(start, mid);
            
            else 
                return binarySearch(mid + 1, end);
        }
        return false;
    }
}```