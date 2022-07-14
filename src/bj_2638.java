import java.io.*;
import java.util.StringTokenizer;

public class bj_2638 {

    static int[][] cheeze;
    static int[][] damagedCheeze;
    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheeze = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheeze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        damagedCheeze = cheeze;
        dfs_1(0,0);
        System.out.println(cheeze);
    }

    static void dfs_1(int i, int j) {
        if (i < 0 || i > N - 1 || j < 0 || j > M - 1) {
            return;
        }
        else if (cheeze[i][j] >= 1) {
            damagedCheeze[i][j] += 1;
        }
        else if (cheeze[i][j] == 0) {
            dfs_1(i, j + 1);
            dfs_1(i + 1, j);
        }
    }

    static void dfs_2(int i, int j) {
        if (i < 0 || i > N - 1 || j < 0 || j > M - 1) {
            return;
        }
        else if (cheeze[i][j] >= 1) {
            damagedCheeze[i][j] += 1;
        }
        else if (cheeze[i][j] == 0) {
            dfs_1(i + 1, j);
            dfs_1(i, j - 1);
        }
    }
}
