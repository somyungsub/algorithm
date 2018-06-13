package backjune;

import java.util.Scanner;

/*
    예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
    첫째 줄에 N이 주어진다. N은 항상 3*2^k 수이다. (3, 6, 12, 24, 48, ...) (k<=10)
 */
public class Q2448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 3*2^k 줄 3^k 갯수 별은

        for (int i = 1; i <= n; i++) {
            int reminder = i % 3;
            if (reminder == 1) {

            } else if (reminder == 2) {

            } else {
                for (int j = 0; j < 5; j++) {
                    System.out.println("*");
                }
            }
        }
    }

    private static void showStar() {

    }
}
