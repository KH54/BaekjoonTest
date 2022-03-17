import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number);
        for (int i : number) {
            sb.append(i);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
