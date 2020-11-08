package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if(stack != null && stack.size() != 0 && stack.size() != 1)
            helperReverse(stack, 0, stack.size() - 1);
    }

    private static void helperReverse(Stack<Integer> stack, int l, int r) {
        if(l >= r) return;
        int tmp = stack.get(l);

        stack.set(l, stack.get(r));
        stack.set(r, tmp);
        helperReverse(stack, l + 1, r - 1);
    }
}