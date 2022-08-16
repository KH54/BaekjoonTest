import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;

        for (int s = 0; s < S.length(); s++) {
            if (S.charAt(s) == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

        char[] arr = new char[S.length()];

        for (int s = 0; s < S.length(); s++) {
            arr[s] = S.charAt(s);
        }

        zeroCnt /= 2;
        oneCnt /= 2;


        for (int i = 0; i < S.length() && oneCnt != 0; i++) {
            if (arr[i] == '1') {
                oneCnt--;
                arr[i] = '9';
            }
        }

        for (int i = S.length() - 1; i >= 0 && zeroCnt != 0; i--) {
            if (arr[i] == '0') {
                zeroCnt--;
                arr[i] = '9';
            }
        }
        
        for(char str : arr) {
            if(str != '9') {
                sb.append(str);
            }
        }

        System.out.println(sb);
    }

}
