package Strings;

import java.util.Stack;

public class Strings69 {
    public static void main(String[] args) {
        String input = "((a+b))(c+d))";
        int result = checkBrackets(input);
        System.out.println(result);
    }

    public static int checkBrackets(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return i + 1;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return 0; 
        } else {
            return -1;
        }
    }
}

