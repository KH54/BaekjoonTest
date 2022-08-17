import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int now = 0;

        while (N-- > 0) {

            int value = Integer.parseInt(br.readLine());

            if (value > now) {
                for (int i = now + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                
                now = value;
            }

            else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            
            stack.pop();
            sb.append("-\n");
            
        }
        System.out.println(sb);
    }

}
