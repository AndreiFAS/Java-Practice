import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class seminar4 {

    public static void main(String[] args) {

    }

    /*
     * Given the head of a singly linked list, reverse the list, and return the
     * reversed list.
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     */

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    /*
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, and /. Each operand may be an integer or another
     * expression.
     * Note that division between two integers should truncate toward zero.
     * It is guaranteed that the given RPN expression is always valid. That means
     * the expression would always evaluate to a result, and there will not be any
     * division by zero operation.
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     */

    public int evalRPN(String[] tokens) {
        Set<String> operators = Set.of("+", "-", "/", "*");
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (operators.contains(tokens[i])) {
                Integer p2 = stack.pollLast();
                Integer p1 = stack.pollLast();
                switch (tokens[i]) {
                    case "+":
                        stack.add(p1 + p2);
                        break;
                    case "-":
                        stack.add(p1 - p2);
                        break;
                    case "*":
                        stack.add(p1 * p2);
                        break;
                    case "/":
                        stack.add(p1 / p2);
                        break;
                }
            } else {
                stack.add(Integer.valueOf(tokens[i]));
            }
        }
        return stack.poll();
    }

}
