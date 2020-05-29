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
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
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

    /**
     * hash表
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean solution_2(String s, String t) {

        // 长度不一致直接返回
        if (s.length() != t.length()) {
            return false;
        }

        // 遍历s，计算每个元素的自然序号为数组下标，对所在下标的数组值进行+1操作
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        // 遍历t，如果出现某个元素序号的值小于0，说明当前元素不存在s或比s元素出现次数多，则s与t不一致
        for (int i = 0; i < t.length(); i++) {
            if (--table[s.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
