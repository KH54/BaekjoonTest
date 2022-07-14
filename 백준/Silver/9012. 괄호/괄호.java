import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();

        for (int t = 0; t < T; t++) {

            String input = br.readLine();

            int cnt = 0;
            
            for (char part : input.toCharArray()) {
                
                if(part == '(') {
                    cnt++;
                } else {
                    cnt--;
                }
                
                if(cnt < 0) {
                    sb.append("NO\n");
                    break;
                }
            }
            if(cnt == 0) {
                sb.append("YES\n");
            } else if(cnt > 0) {
                sb.append("NO\n");
            }
            
        }
        System.out.println(sb);

    }

}
