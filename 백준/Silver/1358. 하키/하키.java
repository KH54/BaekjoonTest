import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int radius = H / 2;
        int cnt = 0;

        for (int p = 0; p < P; p++) {
            st = new StringTokenizer(br.readLine());

            int pointX = Integer.parseInt(st.nextToken());
            int pointY = Integer.parseInt(st.nextToken());

            // 사각형 안에 존재할 경우
            if (pointX >= X && pointX <= X + W && pointY >= Y && pointY <= Y + H) {
                cnt++;
            }
            // 왼쪽 반원에 존재할 경우
            else if ((Math.pow(pointX - X, 2) + Math.pow(pointY - (Y + radius), 2)) <= Math.pow(radius, 2) && pointX < X) {
                cnt++;
            }
            // 오른쪽 반원에 존재할 경우
            else if ((Math.pow(pointX - (X + W), 2) + Math.pow(pointY - (Y + radius), 2)) <= Math.pow(radius, 2) && pointX > X + W) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
