package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParentheses_20 {

    public static boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> charMap = new HashMap();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');

        for (char c : s.toCharArray()) {
            if (charMap.keySet().contains(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || c != charMap.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        assertTrue(isValid(""));
        assertTrue(isValid("()"));
        assertTrue(isValid("[]"));
        assertTrue(isValid("{()}"));
        assertTrue(isValid("{[(())]}"));

        assertFalse(isValid("["));
        assertFalse(isValid("[(])"));
        assertFalse(isValid("(()"));
        assertFalse(isValid(")"));
    }
}
