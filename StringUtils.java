
public class StringUtils {

    private StringUtils() {
    }

    /**
     * Get char frequency of a string
     * 
     * @param string
     * @return an integer array of size 26 with char frequencies
     * 
     *         Time complexity : O(N) Space complexity : O(1)
     */
    public static int[] getCharCount(String string) {
        int[] counts = new int[26];
        for (int i = 0; i < string.length(); i++) {
            counts[string.charAt(i) - 'a']++;
        }
        return counts;
    }

    /**
     * Check if 2 strings are anagrams
     * 
     * @param a
     * @param b
     * @return true if a and b are anagrams
     * 
     *         Time complexity : O(A + B) Space complexity : O(1)
     */
    public boolean areAnagrams(String a, String b) {
        int[] charCountsInA = getCharCount(a);
        int[] charCountsInB = getCharCount(b);
        for (int i = 0; i < 26; i++) {
            if (charCountsInA[i] != charCountsInB[i]) {
                return false;
            }
        }
        return true;
    }
}