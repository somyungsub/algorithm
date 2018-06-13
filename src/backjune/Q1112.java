package backjune;

import java.util.Scanner;

public class Q1112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int x = sc.nextInt();

        if(x<0){
            int reminder = num%x;
            num = num/x;

        }
        StringBuilder sb = new StringBuilder();
        while(num>=1 || num<=-1){
            int reminder = num%x;
            num = num/x;
            sb.append(reminder);
        }
        System.out.println(sb.reverse().toString());
    }
}
