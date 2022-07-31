import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> nSet = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            nSet.add(br.readLine().trim());
        }

        for (int i = 0; i < m; i++) {
            String checkWord = br.readLine().trim();
            if (nSet.contains(checkWord))
                cnt += 1;
        }

        bw.write(cnt + "");
        bw.close();
    }
}
