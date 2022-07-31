import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj16652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int expect = Integer.parseInt(st.nextToken());
        int remain = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < remain; i++) {
            String[] strArr = br.readLine().split("Re:");
            String origin = strArr[strArr.length-1].trim();
            if (map.containsKey(origin)) {
                if (map.get(origin) < strArr.length)
                    map.put(origin, strArr.length);
            } else {
                map.put(origin, strArr.length);
            }
        }

        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }

        if (sum <= expect)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
