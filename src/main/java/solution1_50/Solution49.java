package solution1_50;

import java.util.*;

/**
 * created at 2019/12/6
 *
 * @author shixi
 */
public class Solution49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapGroup = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            char[] sbChars = new char[26];
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                sbChars[chars[i] - 'a']++;
            }
            for (int i = 0; i < sbChars.length; i++) {
                stringBuilder.append(i + 'a').append(sbChars[i]);
            }
            String key = stringBuilder.toString();
            List<String> strings = mapGroup.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
                mapGroup.put(key, strings);
            }
            strings.add(str);
        }
        List<List<String>> results = new ArrayList<>(mapGroup.values());
        return results;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> x = groupAnagrams(strs);
        System.out.println(x);
    }
}
