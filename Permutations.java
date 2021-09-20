class Solution {
    // public List<List<Integer>> permute(int[] nums) {
      public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    helper(res, nums, new HashSet<>(), new ArrayList<>());
    return res;
  }

  private static void helper(
      List<List<Integer>> res, int[] nums, Set<Integer> set, List<Integer> curr) {
    if (curr.size() == nums.length) {
      res.add(new ArrayList<>(curr));
      return;
    }
    for (int num : nums) {
      if (set.contains(num)) continue;
      set.add(num);
      curr.add(num);
      helper(res, nums, set, curr);
      set.remove(num);
      curr.remove(curr.size() - 1);
    }
  }
}
  
        