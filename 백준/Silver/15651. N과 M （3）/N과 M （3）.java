import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // N까지의 수
    static int N;
    // 뽑을 수 M
    static int M;
    // 뽑은 수를 담을 배열
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        // 끝까지 탐색한 경우
        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 빈틈없이 탐색해야 하기 때문에 1~N까지
        for (int m = 1; m <= N; m++) {
            arr[depth] = m;
            dfs(depth + 1);
        }
    }
}
