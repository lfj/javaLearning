package longlearn;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        String lfj = "nu";
        String s = Optional.ofNullable(lfj).orElse("");

        long ll = 30 * 24 * 60 * 60 * 1000L;
        System.out.println(ll);
        Long currentTimeMillis = System.currentTimeMillis();
        long endTimeId = currentTimeMillis + 99 * 24 * 60 * 60 * 1000L;

        Long a = 100L;
        Long b = 100L;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == 100);
        System.out.println(a.equals(100L));
        System.out.println(a.equals(100));

        Long c = 125L;
        Long d = 125L;
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(c == 125);
        System.out.println(c.equals(125L));
        System.out.println(c.equals(125));

        Long e = 130L;
        Long f = 130L;
        System.out.println(0 == Long.compare(e, f));

        Stack<Integer> stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        stack.size();
        stack.get(0);
        stack.pop();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);

        Deque deque = new LinkedList();
        deque.add(1);
        deque.add(2);
        deque.element();

        Math.max(1, 2);
        Math.min(1, 2);
        Math.abs(2);

        lengthOfLongestSubstring("abcabcbb");

        String str = "sdf";

        str.indexOf("d", 1);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        int max = 1;
        int left = 0;
        Map<Character, Integer> map = new HashMap();
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left) {
                max = Math.max(max, i - left);
                System.out.println(max);
                left = map.get(c) + 1;
            }
            map.put(c, i);
        }
        max = Math.max(max, s.length() - left);
        System.out.println(max);
        return max;
    }
}
