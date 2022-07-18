import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] number;
    public static int[] arr = new int[4];
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            number[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < 4; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        dfs(1, number[0]);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void dfs(int depth, int num) {
        if (depth == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (arr[i] > 0) {
                arr[i]--;

                switch (i) {
                case 0:
                    dfs(depth + 1, num + number[depth]);
                    break;
                case 1:
                    dfs(depth + 1, num - number[depth]);
                    break;
                case 2:
                    dfs(depth + 1, num * number[depth]);
                    break;
                case 3:
                    dfs(depth + 1, num / number[depth]);
                    break;
                }
                
                arr[i]++;
            }
        }
    }
}
