package kakao.one;

public class Q2 {

	public static void main(String[] args) {
		// 3번기회, 점수 0~10, 점수^영역 (S:1, D:2, T:3)
		// 스타(*) : 해당, 이전 점수 *2 
		// 아차(#) : -점수 
		// 스타상 첫번째 -> 해당점수만 * 2
		// 스타 + 스타 중첩가능 -> 4배
		// 스타 + 아차 중청가능 -> -2배
		// 영역은 점수마다 1개만존재
		// 스타,아차상 -> 점수마다 둘중 하나만 존재 or 존재x
		// 총점수 함수
		
		System.out.println(getSum("1S2D*3T"));
		System.out.println(getSum("1D2S#10S"));
		System.out.println(getSum("1D2S0T"));
		System.out.println(getSum("1S*2T*3S"));
		System.out.println(getSum("1D#2S*3S"));
		System.out.println(getSum("1T2D3D#"));
		System.out.println(getSum("1D2S3T*"));
	}
	
	// 총점수 얻기
	private static int getSum(String dartResult) {
		int score = -1;
		int exp = -1;
		int idx = 0;
		int[] sum = new int[3];
		
		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if(Character.isDigit(c)) {
				if(Integer.parseInt(String.valueOf(c)) == 0) {
					score = 10;
					if(i > 0 && !Character.isDigit(dartResult.charAt(i-1))) {
						score = Integer.parseInt(String.valueOf(c));
					}
				}
				else {
					score = Integer.parseInt(String.valueOf(c));
				}
			}
			else if(Character.isAlphabetic(c)) {
				exp = getPowNum(c);
				sum[idx++] = (int) Math.pow(score, exp);
			}
			else if("#".equals(String.valueOf(c))){
				sum[idx-1] = sum[idx-1] * (-1);
			}
			else {
				if(idx - 2 >= 0) {
					sum[idx-2] = sum[idx-2] * 2;
					sum[idx-1] = sum[idx-1] * 2;
				}
				else {
					sum[idx-1] = sum[idx-1] * 2;
				}
			}
			
		}
		
		int total = 0;
		for (int i : sum) {
			total += i;
		}
		
		return total;
	}	
	private static int getPowNum(char c) {
		if('S' == c) {
			return 1;
		}
		else if ('D' == c) {
			return 2;
		}
		else if('T' == c) {
			return 3;
		}
		else {
			return 0;
		}
	}

}
