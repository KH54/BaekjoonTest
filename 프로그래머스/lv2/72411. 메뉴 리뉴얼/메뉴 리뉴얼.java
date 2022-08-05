import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

class Solution {
    public static Map<String, Integer> map = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = -1;
            for (int j = 0; j < orders.length; j++) {
                char[] temp = orders[j].toCharArray();
                Arrays.sort(temp);
                orders[j] = new String(temp);
                
                dfs(orders[j], 0, 0, course[i], "");
            }

            for (String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }

            for (String key : map.keySet()) {
                if (map.get(key) >= 2) {
                    if (max == map.get(key)) {
                        answer.add(key);
                    }
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer.toArray(new String[answer.size()]);
    }

    public static void dfs(String menu, int idx, int depth, int menuLength, String str) {
        if (depth == menuLength) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }

        for (int i = idx; i < menu.length(); i++) {
            dfs(menu, i + 1, depth + 1, menuLength, str.concat(String.valueOf(menu.charAt(i))));
        }
    }

}