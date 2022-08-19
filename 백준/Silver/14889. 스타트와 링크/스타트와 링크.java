import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());



        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(MIN);
    }

    private static void dfs(int value, int depth) {
        if (depth == N / 2) {
            point();
            return;
        }

        for (int i = value; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void point() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                if (visited[i] && visited[j]) {
                    teamStart += arr[i][j];
                    teamStart += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamLink += arr[i][j];
                    teamLink += arr[j][i];
                }
            }
        }

        int resPoint = Math.abs(teamStart - teamLink);

        if (resPoint == 0) {
            System.out.println(0);
            System.exit(0);
        }

        MIN = Math.min(resPoint, MIN);

    }

}
