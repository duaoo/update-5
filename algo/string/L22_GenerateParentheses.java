package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @date 2020-06-11 11:49 下午
 */
public class L22_GenerateParentheses {

    /**
     * 递归
     */
    class solution_1 {

        private List<String> res;

        public List<String> generateParenthesis(int n) {

            res = new ArrayList<>();
            generate(n, 0, 0, "");
            return res;
        }

        private void generate(int n, int left, int right, String str) {

            if (left == n && right == n) {
                res.add(str);
                return;
            }

            if (left < n) {
                generate(n, left + 1, right, str + "(");
            }

            if (right < left) {
                generate(n, left, right + 1, str + ")");
            }
        }
    }

}
