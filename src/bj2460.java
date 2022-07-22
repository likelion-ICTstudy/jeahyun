import java.io.*;
import java.util.StringTokenizer;

public class bj2460 {

    static int[][] matrix = new int[10][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxPassenger = 0;
        int nowPassenger = 0;

        for (int i = 0; i < 10; i++) {
            nowPassenger = nowPassenger - matrix[i][0] + matrix[i][1];
            if (nowPassenger > maxPassenger) {
                maxPassenger = nowPassenger;
            }
        }

        System.out.println(maxPassenger);
    }
}
