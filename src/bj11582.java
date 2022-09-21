import java.io.*;
import java.util.*;

public class bj11582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        List<Long> points = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            points.add(Long.parseLong(st.nextToken()));
        }
        int memberNum = Integer.parseInt(br.readLine().trim());

        // 핵심 로직
        int subN = n / memberNum;

        for (int i = 0; i < memberNum; i++) {
            int start = i * subN;
            int end = start + subN;
            Collections.sort(points.subList(start,end));
        }
        // 핵심 로직

        List<String> strList = new ArrayList<>();
        for (long p : points) {
            strList.add(String.valueOf(p));
        }
        final String join1 = String.join(" ", strList);
        System.out.println(join1);
    }
}
