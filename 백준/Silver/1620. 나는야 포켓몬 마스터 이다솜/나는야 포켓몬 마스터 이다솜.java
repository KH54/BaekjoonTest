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
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        int num = 1;
        String[] pocketName = new String[N];

        for (int n = 0; n < N; n++) {
            String name = br.readLine();
            map.put(name, num++);
            pocketName[n] = name;
        }

        for (int m = 0; m < M; m++) {
            String input = br.readLine();

            if (input.matches("[+-]?\\d*(\\.\\d+)?")) {
                int valueNum = Integer.parseInt(input);
                sb.append(pocketName[valueNum-1]).append("\n");
            } else {
                sb.append(map.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }

}
