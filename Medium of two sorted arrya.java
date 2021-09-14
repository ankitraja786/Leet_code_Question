class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==1  ) return nums2[0];
        if(nums1.length==1 && nums2.length==0  ) return nums1[0];
        int len1=nums1.length;
        int len2=nums2.length;
        int [] arr=new int[len1+len2];
        int j=0;
        for(int i=0;i<len1;i++){
            arr[j]=nums1[i];
            j++;
        }
        for(int i=0;i<len2 && j<len1+len2 ;i++){
            arr[j]=nums2[i];
            j++;
        }
        
        Arrays.sort(arr);
        
        int mid=(arr.length)/2 ;
        if(arr.length % 2 != 0) return arr[mid];
        else return (Double.valueOf(arr[mid]+arr[mid-1])/Double.valueOf(2));
        
        
    }
}