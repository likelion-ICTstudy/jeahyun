import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class bj1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputString = br.readLine().trim();

        for (int i = 1; i < inputString.length(); i++) {
            Set<String> set = new HashSet<>();

            int subStringLength = inputString.length() - i;
            int moveCapacity = inputString.length() - subStringLength;

            System.out.println("i = " + subStringLength);

            for (int j = 0; j <= moveCapacity; j++) {
                String subString = inputString.substring(j, j + subStringLength);
                System.out.println("subString : " + subString);
                if (set.contains(subString)) {
                    bw.write(subStringLength + "");
                    bw.close();
                    return;
                } else {
                    set.add(subString);
                }
            }
        }
        bw.write(0 + "");
        bw.close();
    }
}
