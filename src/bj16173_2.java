import java.io.*;
import java.util.StringTokenizer;

public class bj16173_2 {

    static int[][] matrix;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] startPoint = {0,0};

        if (dfs(startPoint))
            bw.write("HaruHaru");
        else
            bw.write("Hing");
        bw.close();
    }

    public static boolean dfs(int[] point) {
        int x = point[0];
        int y = point[1];
        // 행렬 범위를 벗어난다면 끝내자
        if (x > N - 1 || y > N - 1)
            return false;
        // 현재 좌표가 N - 1, N - 1이면 찾았다!
        if (matrix[x][y] == -1) return true;
        // 현재 좌표의 값이 0이라면 끝내자
        if (matrix[x][y] == 0) return false;
        // 현재 좌표의 값
        int value = matrix[x][y];
        // 현재 좌표에서 갈 수 있는 좌표는 2개(오른쪽, 아래)
        int[] downPoint = {x + value, y};
        int[] rightPoint = {x, y + value};
        return (dfs(downPoint) || dfs(rightPoint));
    }
}
