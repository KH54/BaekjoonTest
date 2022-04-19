import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[30][30];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new int[M+1][N+1];

            sb.append(find(M, N)).append("\n");
        }
        System.out.println(sb);
    }

    static int find(int N, int M) {

        if (arr[N][M] > 0) {
            return arr[N][M];
        }

        if (M == 0 || N == M) {
            return arr[N][M] = 1;
        }

        return arr[N][M] = find(N - 1, M - 1) + find(N - 1, M);
    }
}
