import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> aMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int a = 0; a < A; a++) {
            int num = Integer.parseInt(st.nextToken());

            aMap.put(num, 1);
        }

        st = new StringTokenizer(br.readLine());

        for (int b = 0; b < B; b++) {
            int num = Integer.parseInt(st.nextToken());

            if (aMap.containsKey(num)) {
                aMap.put(num, aMap.get(num) + 1);
            } else {
                aMap.put(num, 1);
            }
        }

        int cnt = 0;

        for (Entry<Integer, Integer> entry : aMap.entrySet()) {
            if (entry.getValue() == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
