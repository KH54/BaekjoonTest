import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int check = 0;
        int max = (int) (Math.log10(N) + 1) * 9;

        if (max > N) {
            max = N - 1;
        }
        
        if(N == 1) {
            System.out.println(0);
        }

        while (max != 0) {

            check = N - max;
            sum = check;

            while (check != 0) {
                sum += check % 10;
                check /= 10;
            }
            if (sum == N) {
                System.out.println(N - max);
                break;
            } else {
                max--;
            }
            if (max == 0) {
                System.out.println(0);
            }
        }
    }

}
