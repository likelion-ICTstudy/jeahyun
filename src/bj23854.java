import java.util.*;

public class bj23854 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score_1 = sc.nextInt();
        int score_2 = sc.nextInt();

        if ( (score_1 % 3) == (score_2 % 3) )
            System.out.println( (score_1 / 3) + " " + (score_1 % 3) + " " + (score_2 / 3) );
        else
            System.out.println(-1);
    }
}
