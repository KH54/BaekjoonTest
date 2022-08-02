import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            String str = br.readLine();

            int cnt = 0;
            line: for (char smallWord : str.toCharArray()) {

                switch (smallWord) {
                case '(':
                    cnt++;
                    break;

                case ')':
                    cnt--;
                    if (cnt < 0) {
                        break line;
                    }
                    break;
                }
            }
            if (cnt == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

}
