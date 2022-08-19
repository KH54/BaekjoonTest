import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(dp(N));
    }

    // 반복문으로 처리
    private static int dp(int num) {

        if (num == 1) {
            return 1;
        }

        else if (num == 2) {
            return 2;
        }

        // 이전 값
        int prev = 1;
        // 현재 값
        int now = 2;
        // 합계
        int sum = 0;

        for (int n = 2; n < num; n++) {
            // 계산할때마다 나누는 이유는 값이 너무 커져서 오버플로우가 발생하기 때문에
            sum = (prev + now) % 15746;
            prev = now;
            now = sum;
        }
        return sum;
    }

}
