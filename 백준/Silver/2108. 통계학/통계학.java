import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        if (N == 1) {
            sb.append(arr[0]).append("\n").append(arr[0]).append("\n").append(arr[0]).append("\n").append(0);
        } else {
            sb.append((int) one(arr)).append("\n");
            sb.append(two(arr)).append("\n");
            sb.append(three(arr)).append("\n");
            sb.append(four(arr));
        }
        
        System.out.println(sb);
    }

    static double one(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        return Math.round((double) sum / arr.length);
    }

    static int two(int[] arr) {

        return arr[arr.length / 2];
    }

    static int three(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<Integer> list = new ArrayList<>();

        int max = Collections.max(map.values());

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == max) {
                list.add(m.getKey());
            }
        }
        
        Collections.sort(list);

        if (list.size() > 1) {
            return list.get(1);
        } else {
            return list.get(0);
        }
    }

    static int four(int[] arr) {
        return arr[arr.length - 1] - arr[0];
    }
}
