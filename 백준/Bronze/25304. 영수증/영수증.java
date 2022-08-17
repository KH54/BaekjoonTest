import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int price = 0;

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            price += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        if (price == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
