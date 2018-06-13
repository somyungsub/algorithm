package backjune;

import java.util.Scanner;

/*
    어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
    등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고,
    N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 */
public class Q1065 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(i/10 < 10){
                count++;
                continue;
            }
            String num = String.valueOf(i);
            int preNum = Integer.parseInt(String.valueOf(num.charAt(0))) - Integer.parseInt(String.valueOf(num.charAt(1)));
            boolean flg = true;
            for (int j = 0; j < num.length()-1; j++) {
                int a = Integer.parseInt(String.valueOf(num.charAt(j)));
                int b = Integer.parseInt(String.valueOf(num.charAt(j+1)));
                if (preNum != a - b) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                count++;
            }
        }
        System.out.println(count);
    }
}
