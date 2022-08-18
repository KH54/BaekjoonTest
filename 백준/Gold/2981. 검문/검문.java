import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int num = arr[1] - arr[0];

        for (int i = 2; i < N; i++) {
            num = gcd(num, arr[i] - arr[i - 1]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sb.append(i).append(" ");
            }
        }
        sb.append(num);
        
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
