import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        HashMap<String, Integer> map = new HashMap<>();

        int cnt = 0;

        for (int i = 0; i <= S.length(); i++) {
            for (int j = i; j <= S.length(); j++) {
                String sum = S.substring(i, j);

                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                    cnt++;
                }
            }
        }

        System.out.println(cnt-1);
    }

}
