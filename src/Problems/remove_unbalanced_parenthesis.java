package Problems;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class remove_unbalanced_parenthesis {
    static void main() {

        System.out.println(remove("((abc)((de))"));
    }

    static String remove(String str) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else if (c == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }
        for (int j = 0; j < str.length(); j++) {
            if (!set.contains(j)) {
                sb.append(str.charAt(j));
            }
        }
        return sb.toString();
    }

}

