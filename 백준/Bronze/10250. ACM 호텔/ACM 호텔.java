import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int row = 1;
            int col = 1;

            int[][] arr = new int[H][W];
            for (int m = 0; m < W; m++) {
                for (int k = 0; k < H; k++) {
                    if (arr[k][m] == 0) {
                        arr[k][m] = 1;
                        cnt++;
                        row = k;
                    }
                    if (cnt == N) {
                        break;
                    }
                } col = m;
                if (cnt == N) {
                    break;
                }
                
            } 
            row++;
            col++;
            if(col < 10) {
                sb.append(row);
                sb.append("0");
                sb.append(col);
                sb.append("\n");
            } else {
                sb.append(row);
                sb.append(col);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}