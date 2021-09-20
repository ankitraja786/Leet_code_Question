
      public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1); // Removes right set bit each time
            count++;
        }  return count;  
    }
}
        
    