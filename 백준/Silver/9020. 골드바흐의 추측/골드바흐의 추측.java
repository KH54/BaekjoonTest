import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] prime;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T != 0) {
            int n = Integer.parseInt(br.readLine());

            int p1 = n / 2;
            int p2 = n / 2;

            make_prime(n);

            while (true) {
                if (prime[p1] == false && prime[p2] == false) {
                    sb.append(p2);
                    sb.append(" ");
                    sb.append(p1);
                    sb.append("\n");
                    break;
                }
                p1++;
                p2--;
            }
            T--;

        }
        System.out.println(sb);
    }

    // N이하의 소수 구하기
    public static void make_prime(int N) {
        prime = new boolean[N + 1];

        prime[0] = prime[1] = true;
        if (N < 2) {
            return;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i] == true) {
                continue;
            }

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
