import java.io.*;
import java.util.*;

public class bj11582_2 {

    public static void sort(int[] arr, int low, int high, int n) {
        if (high - low < 2) {
            return;
        }

        int mid = (low + high) / 2;
        sort(arr, low, mid, n);
        sort(arr, mid, high, n);
        if (high - low <= n) {
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low];
        int t = 0, l = low, r = mid;

        while (l < mid && r < high) {
            if (arr[l] < arr[r]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[r++];
            }
        }

        while (l < mid) {
            temp[t++] = arr[l++];
        }

        while (r < high) {
            temp[t++] = arr[r++];
        }

        for (int i = low; i < high; i++) {
            arr[i] = temp[i - low];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfStore = Integer.parseInt(br.readLine().trim());
        int[] points = new int[numOfStore];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfStore; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        int numOfMember = Integer.parseInt(br.readLine().trim());

        int n = numOfStore / numOfMember;

        sort(points, 0, numOfStore, n);

        List<String> strList = new ArrayList<>();
        for (long p : points) {
            strList.add(String.valueOf(p));
        }
        final String join1 = String.join(" ", strList);
        System.out.println(join1);
    }
}
