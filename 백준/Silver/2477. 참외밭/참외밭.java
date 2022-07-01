import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 참외의 개수
        int K = Integer.parseInt(br.readLine());

        // arr[방향][길이]
        int[][] arr = new int[6][2];

        // 큰 사각형의 너비 및 높이
        int maxWidth = 0;
        int maxHeight = 0;
        
        // 작은 사각형의 너비 및 높이
        int minWidth = 0;
        int minHeight = 0;

        // 큰 사각형의 배열 위치
        int idxWidth = 0;
        int idxHeight = 0;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            // 동-서 방향
            if (arr[i][0] == 1 || arr[i][0] == 2) {
                if (arr[i][1] > maxWidth) {
                    // 가장 긴 너비
                    maxWidth = arr[i][1];
                    idxWidth = i;
                }
            } else { // 남-북 방향
                if (arr[i][1] > maxHeight) {
                    // 가장 긴 높이
                    maxHeight = arr[i][1];
                    idxHeight = i;
                }
            }
        }
        // 가장 긴 너비의 좌우 및 가장 긴 높이의 위 아래에 연결된 길이
        int right;
        int left;

        right = idxWidth + 1 == 6 ? 0 : idxWidth + 1;
        left = idxWidth - 1 == -1 ? 5 : idxWidth - 1;

        minHeight = Math.abs(arr[right][1] - arr[left][1]);

        right = idxHeight + 1 == 6 ? 0 : idxHeight + 1;
        left = idxHeight - 1 == -1 ? 5 : idxHeight - 1;

        minWidth = Math.abs(arr[right][1] - arr[left][1]);

        System.out.println(((maxWidth * maxHeight) - (minWidth * minHeight)) * K);
    }

}
