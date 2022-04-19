import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1][K+1];

        System.out.println(find(N, K)); 
    }

    static int find(int N, int K) {

        if (arr[N][K] > 0) {
            return arr[N][K];
        }

        if (K == 0 || N == K) {
            return arr[N][K] = 1;
        }

        return arr[N][K] = (find(N - 1, K - 1) + find(N - 1, K)) % 10007;

    }
}
