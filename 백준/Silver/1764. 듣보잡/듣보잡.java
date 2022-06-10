import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 듣도 못한 사람
        int N = Integer.parseInt(st.nextToken());
        // 보도 못한 사람
        int M = Integer.parseInt(st.nextToken());

        // 듣보잡 수
        int cnt = 0;
        ArrayList<String> list = new ArrayList<>();

        // 듣도 못한 사람 저장
        HashMap<String, Integer> map = new HashMap<>();

        for (int n = 0; n < N; n++) {
            String name = br.readLine();
            map.put(name, 1);
        }

        for (int m = 0; m < M; m++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                list.add(name);
                cnt++;
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(list);
        
        for(int i = 0 ; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        
        System.out.println(sb);
        
    }

}
