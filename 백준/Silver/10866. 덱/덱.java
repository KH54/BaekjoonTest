import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<Integer>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            String input = st.nextToken();

            int num = 0;

            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (input) {
            case "push_back":
                deque.addLast(num);
                break;

            case "push_front":
                deque.addFirst(num);
                break;

            case "pop_front":
                if (!deque.isEmpty()) {
                    sb.append(deque.pollFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
                break;

            case "pop_back":
                if (!deque.isEmpty()) {
                    sb.append(deque.pollLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
                break;

            case "size":
                sb.append(deque.size()).append("\n");
                break;

            case "empty":
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                break;

            case "front":
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
                break;

            case "back":
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
                break;
            }
        }
        
        System.out.println(sb);
    }
}
