import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long countFive = five_check(n) - five_check(n - m) - five_check(m);
        long countTwo = two_check(n) - two_check(n - m) - two_check(m);

        System.out.println(Math.min(countFive, countTwo));
    }

    public static long five_check(long num) {
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }

        return count;
    }

    public static long two_check(long num) {
        int count = 0;

        while (num >= 2) {
            count += num / 2;
            num /= 2;
        }

        return count;
    }
}
