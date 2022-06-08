import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int n = 0; n < N; n++) {
            map.put(br.readLine(), 0);
        }

        for (int m = 0; m < M; m++) {
            if (map.containsKey(br.readLine())) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }

}
