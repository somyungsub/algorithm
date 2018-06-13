package backjune;

import java.util.Scanner;

public class Q1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int temp = 1;
            for (int j = 1; j <= b; j++) {
                temp *= a;
                if(temp > 10){
                    temp = temp % 10 + 10;
                }
            }
            temp = temp > 10 ? temp % 10 : temp;
            System.out.println(temp % 10 == 0 ? 10 : temp);
        }
    }
}
