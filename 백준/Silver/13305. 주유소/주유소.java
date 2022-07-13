import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger[] distance = new BigInteger[N - 1];

        BigInteger payMoney = new BigInteger("0");

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N - 1; n++) {
            distance[n] = new BigInteger(st.nextToken());
        }

        BigInteger minDistance = new BigInteger("0");

        st = new StringTokenizer(br.readLine());
        BigInteger minCost = new BigInteger(st.nextToken());

        for (int n = 1; n < N; n++) {
            BigInteger cost = new BigInteger(st.nextToken());

            minDistance = minDistance.add(distance[n - 1]);
            if (cost.compareTo(minCost) < 0 || (n == N - 1 && minDistance.compareTo(new BigInteger("0")) != 0)) {
                payMoney = payMoney.add(minCost.multiply(minDistance));
                minCost = cost;
                minDistance = new BigInteger("0");
            }

        }

        if (payMoney.compareTo(new BigInteger("0")) == 0) {
            payMoney = payMoney.add(minDistance.multiply(minCost));
        }

        System.out.println(payMoney);

    }

}
