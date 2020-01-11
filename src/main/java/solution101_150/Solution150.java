package solution101_150;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * created at 2020/1/10
 *
 * @author shixi
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer num = stack.pop();
                    stack.push(stack.pop() / num);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution150 solution150 = new Solution150();
        String[] tokens = new String[]{"2", "1", "-"};
        int result = solution150.evalRPN(tokens);
        System.out.println(result);
        Assertions.assertEquals(result, 1);

        String[] tokens2 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result2 = solution150.evalRPN(tokens2);
        System.out.println(result2);
        Assertions.assertEquals(result2, 22);
    }
}
