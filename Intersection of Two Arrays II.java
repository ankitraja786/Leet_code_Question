Arrays.sort(nums1); // First sort the array
        Arrays.sort(nums2); // Similar this one as well
        
        int i = 0; // "i" will point at nums1
        int j = 0; // "j" will point at nums2
        int k = 0; // "k" will point at nums1 and helps in getting the intersection answer; 
        
        while(i < nums1.length && j < nums2.length){ // Loop will run until "i" & "j" doesn't reach the array boundary; 
            if(nums1[i] < nums2[j]){ // Check if nums1 value is less then nums2 value;
                i++; // Increment "i"
            }
            else if(nums1[i] > nums2[j]){ // Check if nums2 value is less then nums1 value;
                j++; // Increment "j"
            }
            else{ // Check if nums1 value is equals to nums2 value;
                nums1[k++] = nums1[i++]; // Dump into nums1 and increment k, increment i & increment j as well;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k); // Only return nums1 0th index to kth index value, because that's will be our intersection;
    }






// Solved using HashMap
public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new LinkedList<>(); // Created ans array where our answer will be stored
        Map<Integer, Integer> map1 = new HashMap<>(); // Created frequency map1 for nums1 array
        Map<Integer, Integer> map2 = new HashMap<>(); // Similarly created frequency map2 for nums2 array
        
        for(int i = 0; i < nums1.length; i++){ // Running the for loop to get and update each integer occurence in array
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1); // Integer repeat and it's occur time will store in map called frequency map
        }
        
        for(int i = 0; i < nums2.length; i++){ // Similar Running the for loop to get and update each integer occurence in array
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        
        for(Integer key: map1.keySet()){ // After having the frequency of both array, have to check which of them are intersecting
            if(map2.containsKey(key)){
                int min = Math.min(map1.get(key), map2.get(key)); // Get the minimum frequency of intersectiong one
                
                while(min --> 0){
                    ans.add(key); // Add it into ans
                }
            }
        }
        int res[] = new int[ans.size()]; // Create result to give output in form of array whose size will be equals to answer array
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i); // Put inside result all the answer value 
        }
        return res; // return it;
    }
Time Complexity: BigO(n+m), where n and m are the lengths of the arrays. We iterate through the first, and then through the second array; insert and lookup operations in the hash map take a constant time.

Space Complexity: BigO(min(n,m)). We use hash map to store numbers (and their counts) from the smaller array.