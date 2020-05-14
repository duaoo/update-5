package stack;

import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @date 2020-05-06 11:58 下午
 */
public class L20_IsValid {

    /**
     * 利用栈
     */
    public boolean solution_1(String s) {

        // 奇数个自然不符合
        if (s.length() % 2 != 0) {
            return false;
        }

        // 创建栈
        Stack<Character> deque = new Stack<>();
        // 遍历每个字符
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {

                // 当遇到左括号时，把右括号压栈
                case '(':
                    deque.push(')');
                    break;
                case '{':
                    deque.push('}');
                    break;
                case '[':
                    deque.push(']');
                    break;
                default:
                    // 当不上左括号的时候，如果栈为空或栈顶元素不是与当前元素相同时，则括号不匹配
                    if (deque.isEmpty() || s.charAt(i) != deque.pop()) {
                        return false;
                    }
            }
        }

        return deque.isEmpty();
    }

}
