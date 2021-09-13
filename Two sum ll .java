class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int n = numbers.length;
        int [] res = new int [2];
        int start = 0;
        int end = n-1;
        for(int i = 0;i<n;i++)
        {
            if(numbers[start]+numbers[end] > target)
                end --;
            else if(numbers[start]+numbers[end] < target)
                start++;
            else
            {
                res[0] = start+1;
                res[1] = end+1;
                return res;
                
            }
        }
        
        return res;
        
    }
}
        