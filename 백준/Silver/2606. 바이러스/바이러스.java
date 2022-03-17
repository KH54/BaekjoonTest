import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Search search = new Search(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            search.makeUndirectEdge(x, y);
        }

        search.bfs(1);
    }

}

class Search {
    int vertexCnt;
    int[][] m;
    boolean[] visit;

    public Search(int N) {
        N += 1;
        vertexCnt = N;
        m = new int[N][N];
        visit = new boolean[N];
    }

    public void makeUndirectEdge(int from, int to) {
        m[from][to] = 1;
        m[to][from] = 1;
    }

    public void bfs(int v) {
        int count = -1;
        Queue<Integer> q = new LinkedList<>();

        q.offer(v);

        visit[v] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            count++;

            for (int i = 0; i < vertexCnt; ++i) {
                if (!visit[i] && m[now][i] == 1) {

                    visit[i] = true;

                    q.offer(i);
                }
            }
        }
        System.out.println(count);
    }
}
