import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M > N) {
            int temp = N;
            N = M;
            M = temp;
        }

        int result = GCD(N, M);

        System.out.println(result);
        System.out.println(N * M / result);
    }

    public static int GCD(int N, int M) {
        if (N % M == 0) {
            return M;
        }
        return GCD(M, N % M);
    }

}
