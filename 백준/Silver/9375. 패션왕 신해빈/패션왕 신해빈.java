import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int n;
        String str;

        HashMap<String, Integer> map;

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken();

                str = st.nextToken();

                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);

                }

            }
            int result = 1;

            for (int count : map.values()) {
                result *= (count + 1);
            }
            sb.append(--result).append("\n");

        }
        System.out.println(sb);
    }
}
