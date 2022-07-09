import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        for (int n = N - 1; n >= 0; n--) {
            if (K > 0) {
                int cacul = K / arr[n];

                if (cacul > 0) {
                    K -= cacul * arr[n];
                    cnt += cacul;
                }
            }
        }
        
        System.out.println(cnt);
    }

}
