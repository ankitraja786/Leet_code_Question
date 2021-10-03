class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> umap = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            if(umap.containsKey(target - nums[i])){
                int []ans = {i, umap.get(target - nums[i])};
                return ans;
            }          
            umap.put(nums[i], i);
        }
        int []ans = {};
        return ans;
    }
}