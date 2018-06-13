package kakao.three;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 진법
		int t = sc.nextInt();	// 미리구할숫자 수
		int m = sc.nextInt();	// 참가인원
		int p = sc.nextInt(); 	// 튜브의 순서
		
		int idx = 0;
		int value = (int)Math.pow(n, idx);
		
		StringBuilder sb = new StringBuilder();
		sb.append("0");
		for (int i = 1; i <= m*t; i++) {
			if(value == i) {
				value = (int)Math.pow(n, ++idx);
				for (int j = i; j < value; j++) {
					int a = j;
					StringBuilder sb2 = new StringBuilder();
					while(a > 0) {
						int reminder = a % n;
						a = a / n;
						if(reminder >= 10) {
							char ch = (char)(65 + (reminder % 10));
							sb2.append(ch);
						}
						else {
							sb2.append(reminder);	// A : 65 ~ 70
						}
					}
					sb.append(sb2.reverse().toString());
				}
			}
		}
//		System.out.print(sb.toString());
		for (int i = 1; i <= m*t; i++) {
			// 튜브 순서
			if(i % m == (p == m ? 0 : p)) {
				System.out.print(sb.toString().charAt(i-1));
			}
		}
		sc.close();
	}

}
