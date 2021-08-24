class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      
      Queue<TreeNode> queue = new LinkedList(); 
      List<List<Integer>> result = new ArrayList();
      List<Integer> current = new ArrayList();
        
      int count =1;
      if(root == null) return result;
      
      queue.offer(root);
      queue.offer(null);
      
      while(!queue.isEmpty()){
        TreeNode temp = queue.poll();
        
        if(temp!= null){
          current.add(temp.val);
          if(temp.left !=null)
            queue.offer(temp.left);
            if(temp.right !=null)
              queue.offer(temp.right);
        }
        else
        {
          if(count%2==0)
            Collections.reverse(current);
          
          ArrayList<Integer> res = new ArrayList<>(current);
          result.add(res);
          current.clear();
          
          if(!queue.isEmpty())
          {
            queue.offer(null);
            count ++;
          }
        }
      }
      return result;
    }
}