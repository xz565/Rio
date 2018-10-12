package company.gg;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacterInAString_387 {

    public int firstUniqChar_2(String s) {
//        Map<Character, Integer> map = new LinkedHashMap<>();
//        for (char c : s.toCharArray()) {
//            if (!map.containsKey(c)) {
//                map.put(c, 0);
//            }
//            map.put(c, map.get(c) + 1);
//        }
//        Optional<Map.Entry<Character, Integer>> match =
//                map.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();
//        return match.isPresent() ? match.get().getKey() : -1;
//        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        Set<Character> uniqueSet = new HashSet<>();
        Set<Character> dupSet = new HashSet<>();
        for (char c : s.toCharArray()) if (!dupSet.contains(c)) {
            if (!uniqueSet.contains(c)) {
                uniqueSet.add(c);
            } else {
                uniqueSet.remove(c);
                dupSet.add(c);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (uniqueSet.contains(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar(String s) {
        boolean[] unique = new boolean[256];
        boolean[] dup = new boolean[256];
        for (char c : s.toCharArray()) if (!dup[c]) {
            if (!unique[c]) {
                unique[c] = true;
            } else {
                unique[c] = false;
                dup[c] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) if (unique[s.charAt(i)]) {
            return i;
        }
        return -1;
    }
}
