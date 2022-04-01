import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int circle = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            int check = Integer.parseInt(st.nextToken());

            int result = circle * check / gcd(circle, check);

            sb.append(result / check).append("/").append(result / circle).append("\n");

        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
