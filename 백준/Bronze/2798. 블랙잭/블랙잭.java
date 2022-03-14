import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] number = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(blackJack(number, N, M));
    }

    static int blackJack(int[] number, int N, int M) {
        int result = 0;

        for (int a = 0; a < N - 2; a++) {

            for (int b = a + 1; b < N - 1; b++) {

                for (int c = b + 1; c < N; c++) {

                    int temp = number[a] + number[b] + number[c];

                    if (M == temp) {
                        return temp;
                    }

                    if (result < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }

}
