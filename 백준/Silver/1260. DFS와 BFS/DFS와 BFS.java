import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Search {
    // 노드의 개수
    int vertexCnt;

    // 간선 배열
    int[][] m;

    // 다녀온 노드 배열
    boolean[] visited;

    // 출력값 저장
    StringBuilder sb;

    // 노드의 수를 이용해 초기화
    public Search(int N) {
        N += 1;
        vertexCnt = N;
        m = new int[N][N];
        visited = new boolean[N];
    }

    // dfs 출력 후 bfs 출력을 위한 초기화
    public void init() {
        Arrays.fill(visited, false);
    }

    // 연결된 간선
    public void makeUndirectedEdge(int from, int to) {
        m[from][to] = 1;
        m[to][from] = 1;
    }

    // DFS 출력
    public void dfs(int v) {
        sb = new StringBuilder();

        // 스택 생성
        Stack<Integer> st = new Stack<>();

        // 시작 노드 입력
        st.push(v);

        // 시작 노드 방문 처리
        visited[v] = true;

        sb.append(v).append(" ");

        // 스택이 비워질 때 까지 반복
        while (!st.isEmpty()) {
            // 현재 노드 반환, 삭제 X
            int now = st.peek();

            boolean flag = false;

            // 노드의 수 만큼 반복
            for (int i = 0; i < vertexCnt; ++i) {
                // 방문하지 않았고, 간선이 존재하는 경우
                if (m[now][i] == 1 && !visited[i]) {

                    // 방문 처리
                    visited[i] = true;

                    // 플래그 변경
                    flag = true;

                    // 스택에 값 저장
                    st.push(i);
                    sb.append(i).append(" ");
                    break;
                }
            }

            if (!flag) {
                // 방문한 노드 삭제
                st.pop();
            }
        }
        System.out.println(sb);
    }

    // 너비 우선 탐색
    public void bfs(int v) {

        sb = new StringBuilder();

        // 큐 생성
        Queue<Integer> q = new LinkedList<>();

        // 시작 지점
        q.offer(v);

        // 시작 지점 방문 처리
        visited[v] = true;

        // 큐가 비워질 때 까지 반복
        while (!q.isEmpty()) {
            // 반환하고 제거, 없으면 null
            int now = q.poll();

            sb.append(now).append(" ");

            // 노드의 수 만큼 반복
            for (int i = 0; i < vertexCnt; ++i) {
                // 방문하지 않았고, 근처 노드가 존재하는 경우
                if (m[now][i] == 1 && !visited[i]) {
                    // 방문 처리
                    visited[i] = true;
                    // 큐에 추가
                    q.offer(i);

                    // offer와 add의 차이
                    // offer : 큐가 가득 차서 추가할 수 없는 걍우 false 반환
                    // add : Exception을 발생 시킴
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

        // 노드의 수
        int N = Integer.parseInt(st.nextToken());
        // 간선의 수
        int M = Integer.parseInt(st.nextToken());
        // 최초 시작 지점
        int V = Integer.parseInt(st.nextToken());

        // 기본 생성자 생성
        Search search = new Search(N);

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            search.makeUndirectedEdge(x, y);
        }

        // 깊이 우선 탐색 실행
        search.dfs(V);
        // visited 초기화
        search.init();
        // 너비 우선 탐색 실행
        search.bfs(V);
    }

}
