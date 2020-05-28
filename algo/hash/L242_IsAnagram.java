package hash;

import java.util.Arrays;

/* 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram
 *
 * @date 2020-05-28 23:16 下午
 */
public class L242_IsAnagram {


    /**
     * 暴力求解
     */
    public boolean solution_1(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}
