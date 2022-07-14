import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj16173 {

    static boolean find = false;
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
        dfs(Arrays.asList(0, 0));

        if (find == true)
            bw.write("HaruHaru");
        else
            bw.write("Hing");
        bw.close();
    }

    public static void dfs(List<Integer> list) {
        int x = list.get(0);
        int y = list.get(1);

        // 행렬 범위를 벗어난다면 끝내자
        if (x > N - 1 || y > N - 1)
            return;
        // 현재 좌표의 값
        int value = matrix[x][y];
        // 현재 좌표의 값이 0이라면 끝내자
        if (value == 0) return;
        // 현재 좌표가 -1이다. 찾았다!
        if (value == -1) {
            find = true;
            return;
        }
        // 현재 좌표에서 갈 수 있는 좌표는 2개(오른쪽, 아래)
        List<List<Integer>> reachablePoints = new ArrayList<>();
        reachablePoints.add(Arrays.asList(x + value, y));
        reachablePoints.add(Arrays.asList(x, y + value));

        for (List<Integer> point : reachablePoints) {
            if (find == false)
                dfs(point);
            if (find == true) {
                return;
            }
        }
    }
}
