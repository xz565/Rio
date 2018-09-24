package dp;

public class RegularExpressionMatching {

    // Add a boolean cache[i][j],
    // which denotes whether s.subString[i] matches p.subString[j]
    // // TODO revisit - 9/23/2018
    public boolean isMatch(String s, String p) {
//        int sIdx = 0, pIdx = 0;
//        if (sIdx < s.length() && pIdx < p.length()) {
//            char sChar = s.charAt(sIdx);
//            char pChar = p.charAt(pIdx);
//            if (sChar == pChar || '.' == pChar) {
//                if (pIdx + 1 < p.length() && '*' == p.charAt(pIdx + 1)) {
//                    return isMatch(s.substring(1), p)
//                            || isMatch(s.substring(1), p.substring(2));
//                } else {
//                    return isMatch(s.substring(1), p.substring(1));
//                }
//            }
//        }
        return s.isEmpty() && p.isEmpty();
    }
}
