package leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyThread extends Thread {

    public boolean checkValidString(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        int size = s.length();
        for (int i=0;i<size;i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack1.push(i);
            } else if (c == '*') {
                stack2.push(i);
            } else if (c == ')') {
                if (stack1.isEmpty()) {
                    if (stack2.isEmpty()) {
                        return false;
                    } else {
                        stack2.pop();
                    }
                } else {
                    stack1.pop();
                }
            }
        }
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer left = stack1.pop();
                Integer right = stack2.pop();
                if (right < left) {
                    return false;
                }
            }
        }
        return stack1.isEmpty();
    }

    public static boolean isValid(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack();
        for (int i=0;i<s.length();i++) {
            int size = stack.size();
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
            } else {
                if (null != map.get(stack.get(size - 1)) && map.get(stack.get(size - 1)) == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.add(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread threadA = new MyThread("A");
        MyThread threadB = new MyThread("B");
        MyThread threadC = new MyThread("C");

        threadA.start();
        threadA.join();
        threadB.start();
        threadB.join();
        threadC.start();

        isValid("([)]");
    }
}
