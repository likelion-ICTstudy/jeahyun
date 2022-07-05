import java.util.*;

public class bj2579 {
    static int[] pointArr;
    static int[] maxArr; // memo

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfStep = sc.nextInt();
        pointArr = new int[numOfStep + 1];
        maxArr = new int[numOfStep + 1];

        for (int i = 1; i < numOfStep + 1; i++) {
            pointArr[i] = sc.nextInt();
        }

        if (numOfStep >= 1) maxArr[1] = pointArr[1];
        if (numOfStep >= 2) maxArr[2] = pointArr[1] + pointArr[2];
        if (numOfStep >= 3) maxArr[3] = Math.max(pointArr[1], pointArr[2]) + pointArr[3];

        int answer = maxPoint(numOfStep);

        System.out.println(answer);
    }

    public static int maxPoint(int n) {
        if (maxArr[n] != 0) return maxArr[n];
        maxArr[n] = Math.max(maxPoint(n-3) + pointArr[n-1], maxPoint(n-2)) + pointArr[n];
        return maxArr[n];
    }
}
