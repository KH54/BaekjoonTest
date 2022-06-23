import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 수의 갯수
    static int N;
    // 뽑아올 수의 개수
    static int M;
    // 뽑아온 수를 저장할 배열
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0,1);
        
        System.out.println(sb);
    }

    private static void dfs(int depth, int value) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int n = value; n <= N; n++) {
            arr[depth] = n;
            
            dfs(depth + 1, n);
        }
    }

}
