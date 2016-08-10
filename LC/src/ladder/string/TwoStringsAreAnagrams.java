package ladder.string;

/**
 * Created by xiaodz on 8/9/16.
 */
public class TwoStringsAreAnagrams {
    public boolean anagram(String s, String t) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int j = 0; j <t.length(); j++) {
            count[t.charAt(j)]--;
            if (count[t.charAt(j)] < 0) {
                return false;
            }
        }
        return true;
    }
}
