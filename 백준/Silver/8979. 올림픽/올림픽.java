import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] rank = new int[N][5];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < 4; m++) {
                rank[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(rank, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o2[3] - o1[3];
                    } else {
                        return o2[2] - o1[2];
                    }
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        
        int rate = 1;
        int count = 1;

        if(rank[0][0] == K) {
            System.out.println(1);
        } else {
            for(int n = 1 ; n < N; n++) {
                if((rank[n][1] != rank[n-1][1]) || (rank[n][2] != rank[n-1][2]) || (rank[n][3] != rank[n-1][3])) {
                    rate += count;
                    count = 1;
                } else {
                    count++;
                }
                
                if(rank[n][0] == K) {
                    System.out.println(rate);
                    break;
                }
            }
        }
    }
}
