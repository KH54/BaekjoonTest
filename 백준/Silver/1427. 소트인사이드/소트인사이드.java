import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();

        int[] counting = new int[10];
        int c;

        while ((c = in.read()) != '\n') {
            counting[c - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            while (counting[i]-- > 0) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }

}
