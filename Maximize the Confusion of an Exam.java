class Solution {
    public int maxConsecutiveAnswers(String key, int k) {
        return Math.max(f(key, 'T', k), f(key, 'F', k));
    }
    private int f(String key, char c, int k) {
        int win = 0;
        for (int lo = -1, hi = 0; hi < key.length(); ++hi) {
            k -= key.charAt(hi) == c ? 1 : 0;
            while (k < 0) {
                k += key.charAt(++lo) == c ? 1 : 0;
            }
            win = Math.max(win, hi - lo);
        }
        return win;
    }
}