import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주유소의 개수
        int N = Integer.parseInt(br.readLine());
        
        // 주유소의 거리
        BigInteger[] distance = new BigInteger[N - 1];

        // 총 지불해야할 돈
        BigInteger payMoney = new BigInteger("0");

        // 각 구역마다 거리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N - 1; n++) {
            distance[n] = new BigInteger(st.nextToken());
        }

        // 가장 저렴한 주유소까지의 최소 거리
        BigInteger minDistance = new BigInteger("0");

        // 가장 저렴한 기름 가격
        st = new StringTokenizer(br.readLine());
        BigInteger minCost = new BigInteger(st.nextToken());

        for (int n = 1; n < N; n++) {
            // 도착한 주유소의 기름 가격
            BigInteger cost = new BigInteger(st.nextToken());

            // 주유한 후 현재까지의 거리
            minDistance = minDistance.add(distance[n - 1]);
            // 현재 주유소의 기름 가격이 작은 경우 or 마지막 주유소까지 도착했을 때 거리가 초기화 되지 않은 경우
            if (cost.compareTo(minCost) < 0 || (n == N - 1 && minDistance.compareTo(new BigInteger("0")) != 0)) {
                payMoney = payMoney.add(minCost.multiply(minDistance));
                minCost = cost;
                minDistance = new BigInteger("0");
            }
        }

        System.out.println(payMoney);

    }

}
