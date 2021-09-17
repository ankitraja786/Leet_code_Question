class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> chars = new HashMap();
        
        // create a map for frequencies for each char
        // [char, how-much-time-this-character-repeated]
        for(Character c: s1.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        
        int length = s1.length(); // size of the window
        int start = 0;
        int end = 0;
        
        // the same map for the "window"
        Map<Character, Integer> testChars = new HashMap();
        
        while(start <= end && end < s2.length()) {
            if(end - start < length) {
                // if the window is not big enought expand it
                char newChar = s2.charAt(end);
                testChars.put(newChar, testChars.getOrDefault(newChar, 0) + 1);
                end++;
            } else {
                // the window size is equal to s1 string
                // so, we can test this map now
                if(mapsAreEqual(chars, testChars)) {
                    // maps are equal
                    return true;
                } else {
                    // this window is too big
                    // remove first character from the string 
                    // and shrink the window for the first character
                    // moving start position
                    char removeChar = s2.charAt(start);
                    testChars.put(removeChar, testChars.get(removeChar) - 1);
                    if(testChars.get(removeChar) <= 0) {
                        testChars.remove(removeChar);
                    }
                    start++;
                }
            }
        }
        
        // if we had increased the size of the window on the last iteration and haven't compared maps yet
        if(mapsAreEqual(chars, testChars)) {
            return true;
        }
        
        return false;
    }
    
    /**
    * Compare two maps
    **/
    private boolean mapsAreEqual(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        // if maps have different amount of keys they are not equal 
        if(m1.size() != m2.size()) {
            return false;
        }
        
        // compare key-value pairs from both maps
        for(Character key : m1.keySet()) {
            if(!m1.containsKey(key)) {
                return false;
            }
            
            if(!m1.get(key).equals(m2.get(key))) {
                return false;
            }
        }
        
        return true;
    }
}