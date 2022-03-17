import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Search {
    int vertexCnt;
    int[][] m;
    boolean[] visited;
    StringBuilder sb;

    public Search(int N) {
        N += 1;
        vertexCnt = N;
        m = new int[N][N];
        visited = new boolean[N];
    }
    
    public void init() {
        Arrays.fill(visited, false);
    }

    public void makeUndirectedEdge(int from, int to) {
        m[from][to] = 1;
        m[to][from] = 1;
    }

    public void dfs(int v) {
        sb  = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        st.push(v);
        visited[v] = true;

        sb.append(v).append(" ");

        while (!st.isEmpty()) {
            int now = st.peek();
            boolean flag = false;

            for (int i = 0; i < vertexCnt; ++i) {
                if (m[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    flag = true;
                    st.push(i);
                    sb.append(i).append(" ");
                    break;
                }
            }

            if (!flag) {
                st.pop();
            }
        }
        System.out.println(sb);
    }

    public void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        sb = new StringBuilder();

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for (int i = 0; i < vertexCnt; ++i) {
                if(m[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        
        System.out.println(sb);
    }
}

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Search search = new Search(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            search.makeUndirectedEdge(x, y);
        }
        search.dfs(V);
        search.init();
        search.bfs(V);
    }

}
