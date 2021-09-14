class Solution {
    public String reverseWords(String s) {
      String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(" ");
        }
        String[] wordsReversed = sb.reverse().toString().split(" ");
        sb.setLength(0); //delete String Builder
        for (int i = wordsReversed.length - 1; i >= 0; i--) {
            sb.append(wordsReversed[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
        
    }
