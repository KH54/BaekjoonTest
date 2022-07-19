import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String line = br.readLine();

        while (!line.equals(".")) {
            
            point: for (char word : line.toCharArray()) {

                switch (word) {
                case '(':
                    stack.push(word);
                    break;

                case '[':
                    stack.push(word);
                    break;

                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    } else if (stack.empty()) {
                        sb.append("no").append("\n");
                        break point;
                    } else {
                        sb.append("no").append("\n");
                        break point;
                    }

                    break;

                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    } else if (stack.empty()) {
                        sb.append("no").append("\n");
                        break point;
                    } else {
                        sb.append("no").append("\n");
                        break point;
                    }
                    break;
                case '.':
                    if (stack.empty()) {
                        sb.append("yes").append("\n");
                    } else {
                        sb.append("no").append("\n");
                    }
                    break;
                }
            }
            
            stack.clear();
            
            line = br.readLine();
        }

        System.out.println(sb);
    }

}
