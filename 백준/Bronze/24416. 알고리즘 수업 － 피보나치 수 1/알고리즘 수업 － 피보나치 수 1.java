import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        sb.append(fibo(N)).append(" ").append(N-2);
        System.out.println(sb);
    }
    
    private static int fibo(int n) {
        if(n == 1 || n == 2) {
            return 1;
        } else {
            return (fibo(n-1) + fibo(n-2));
        }
    }

}
