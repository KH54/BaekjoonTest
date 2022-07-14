import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> input = new Stack<>();

        for (int k = 0; k < K; k++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (!input.isEmpty()) {
                    input.pop();
                }
            } else {
                input.push(num);
            }
        }
        
        int result = 0;
        
        while(!input.isEmpty()) {
            result += input.pop();
        }
        
        System.out.println(result);
    }

}
