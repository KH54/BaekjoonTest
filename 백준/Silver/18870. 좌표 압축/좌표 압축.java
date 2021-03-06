import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] temp = new int[N];
        int rank = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            temp[i] = arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(temp);
        
        for(int r : temp) {
            if(!map.containsKey(r)) {
                map.put(r, rank);
                rank++;
            }
        }
        
        for(int r : arr) {
            sb.append(map.get(r)).append(" ");
        }
        
        System.out.println(sb);
    }

}
