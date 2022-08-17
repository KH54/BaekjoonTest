import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            Point[] road = new Point[2];

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 시작점, 도착점
            for (int i = 0; i < 2; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                road[i] = new Point(x, y);
            }

            // 원 개수
            int N = Integer.parseInt(br.readLine());

            // 지나는 원 개수
            int cnt = 0;

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if (Math.pow(road[0].x - x, 2) + Math.pow(road[0].y - y, 2) < Math.pow(r, 2) //
                        && Math.pow(road[1].x - x, 2) + Math.pow(road[1].y - y, 2) < Math.pow(r, 2)) {
                    continue;
                } //
                else if (Math.pow(road[0].x - x, 2) + Math.pow(road[0].y - y, 2) < Math.pow(r, 2)//
                        || Math.pow(road[1].x - x, 2) + Math.pow(road[1].y - y, 2) < Math.pow(r, 2)) {
                    cnt++;
                }

            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}
