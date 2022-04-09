import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append((int)Math.pow(2, N)-1).append("\n");
        move(N, 1, 3);

        System.out.println(sb);
    }

    static void move(int N, int x, int y) {

        if (N == 1) {
            sb.append(x).append(" ").append(y).append("\n");
            return;
        }

        if (N > 1) {
            move(N - 1, x, 6 - x - y);
        }

        sb.append(x).append(" ").append(y).append("\n");

        if (N > 1) {
            move(N - 1, 6 - x - y, y);
        }
    }

}
