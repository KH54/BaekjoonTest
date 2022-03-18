import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Main {
    static ArrayList<Integer> count = new ArrayList<>();
    static int checkX[] = { -1, 1, 0, 0 };
    static int checkY[] = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int chart[][] = new int[N][N];
        boolean check[][] = new boolean[N][N];

        for (int i = 0; i < chart.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < chart[i].length; j++) {
                chart[i][j] = str.charAt(j) - '0';
            }
        }

        Dot dot;

        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart[i].length; j++) {
                if (chart[i][j] == 1 && !check[i][j]) {
                    dot = new Dot(i, j);
                    bfs(chart, check, dot);
                }
            }
        }
        sb.append(count.size()).append("\n");
        Collections.sort(count);

        for (int i : count) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int[][] chart, boolean[][] check, Dot d) {
        Queue<Dot> q = new LinkedList<>();
        int cnt = 0;

        q.offer(d);
        check[d.getX()][d.getY()] = true;

        while (!q.isEmpty()) {
            Dot dot = q.poll();
            int x = dot.getX();
            int y = dot.getY();

            cnt++;

            for (int i = 0; i < checkX.length; i++) {
                int nx = x + checkX[i];
                int ny = y + checkY[i];

                if (nx >= chart.length || nx < 0 || ny >= chart.length || ny < 0) {
                    continue;
                }

                if (check[nx][ny]) {
                    continue;
                }

                if (chart[nx][ny] == 1) {
                    check[nx][ny] = true;
                    q.offer(new Dot(nx, ny));
                }
            }
        }
        count.add(cnt);
    }

}
