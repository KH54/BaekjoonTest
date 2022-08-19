import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] arr;
    private static int N;
    private static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int n = 0; n < N; n++) {
            arr[depth] = n;

            if (checkPosition(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean checkPosition(int col) {
        for (int c = 0; c < col; c++) {
            if (arr[col] == arr[c]) {
                return false;
            }

            else if (Math.abs(col - c) == Math.abs(arr[col] - arr[c])) {
                return false;
            }
        }

        return true;
    }

}
