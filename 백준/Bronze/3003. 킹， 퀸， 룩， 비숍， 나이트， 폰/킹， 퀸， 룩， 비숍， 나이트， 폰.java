import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] basic = { 1, 1, 2, 2, 2, 8 };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int horse = Integer.parseInt(st.nextToken());

            sb.append(basic[i] - horse).append(" ");

        }
        
        System.out.println(sb);
    }

}
