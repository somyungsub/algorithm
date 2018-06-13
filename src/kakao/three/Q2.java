package kakao.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Map<String, Integer> map = new HashMap<>();
		
		// 초기화 작업
		for(int i = 0; i < 26; i++) {
			char ch = (char)(65+i);
			map.put(String.valueOf(ch), i+1);
		}
		
		// 출력
		List<Integer> outList = new ArrayList<>();
		int i = 0;
		while(i < str.length()) {
			char ch = str.charAt(i);

			StringBuilder sb = new StringBuilder(String.valueOf(ch));
			System.out.println(sb.toString());

			String save = "";
			String getStr = String.valueOf(ch);
			for (int j = i; j < str.length(); j++) {
				int idx = j != str.length() - 1 ? j + 1 : j;
				sb.append(str.charAt(idx));
				if (!map.containsKey(sb.toString())) {
					save = sb.toString();
					i = j;
					break;
				} else {
					getStr = sb.toString();
				}
			}

			if (i == str.length() - 1) {
				outList.add(map.get(String.valueOf(getStr)));
			} else {
				outList.add(map.get(getStr));
				map.put(save, map.size() + 1);
			}
			i++;
		}
		System.out.println(outList);
		
		sc.close();
	}

}
