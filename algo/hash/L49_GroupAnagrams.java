package hash;

import java.util.*;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @date 2020-05-31 11:39 下午
 */
public class L49_GroupAnagrams {

    /**
     * 排序每一个字符串，然后利用Map key来判断异同，相同结果存在value中
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {

            // 字符串排序
            char[] sChar = str.toCharArray();
            Arrays.sort(sChar);
            String sortStr = String.valueOf(sChar);

            // 如不存在Map中，则先创建
            if (!resMap.containsKey(sortStr)) {
                resMap.put(sortStr, new ArrayList<>());
            }

            resMap.get(sortStr).add(str);
        }

        return new ArrayList<>(resMap.values());
    }

}
