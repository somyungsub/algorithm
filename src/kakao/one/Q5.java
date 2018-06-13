package kakao.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Q5 {

	public static void main(String[] args) {
		
		/*
		 * 자카드 유사도 J(A,B) = A교B / A합B
		 * 
		 * A and B 공집합 -> J(A,B) = 1로 예외처리
		 * 
		 * 다중집합 -> 
		 * 
		 * 문자열로
		 * 
		 */
		
		/*
		 *  2글자씩 끊어서 다중집합으로
		 *  영문자만 다중집합만들고 / 기타,공백이나 숫자 특수문자 -> 글자쌍버림 
		 *  대소문자 차이 무시 AB,Ab,ab는 같은원소취급
		 *  65536 곱하고 소수아래는 버림
		 */
		
		String str1 = "FRANCE";
		String str2 = "french";
		show(str1, str2);
		
		String str3 = "handshake";
		String str4 = "shake hands";
		show(str3, str4);
		
		String str5 = "aa1+aa2";
		String str6 = "AAAA12";
		show(str5, str6);
		
		String str7 = "E=M*C^2";
		String str8 = "e=m*c^2";
		show(str7, str8);
	}
	private static void show(String str1, String str2) {
		List<String> list1 = getStringList(str1);
		List<String> list2 = getStringList(str2);
		
		int inter = getIntersetion(list1, list2);
		int union = list1.size() + list2.size() - inter;
		int result = list1.size() == inter && list2.size() == inter ? 65536 : inter*65536/union;
		System.out.println(result);
	}
	
	private static List<String> getStringList(String str) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < str.length()-1; i++) {
			char ch1 = str.charAt(i);
			char ch2 = str.charAt(i+1);
			if(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i+1))) {
				StringBuilder sb = new StringBuilder();
				sb.append(ch1).append(ch2);
				list.add(sb.toString());
			}
		}
		return list;
	}
	
	private static int getIntersetion(List<String> list1, List<String> list2) {
		Map<String, Integer> map1 = getMapStr(list1);
		Map<String, Integer> map2 = getMapStr(list2);
		
		List<String> save = new ArrayList<>();
		for (Entry<String, Integer> entry : map1.entrySet()) {
			String key = entry.getKey();
			if(map2.containsKey(key)) {
				int loopSize = map2.get(key) > entry.getValue() ? entry.getValue() : map2.get(key);
				for (int i = 0; i < loopSize; i++) {
					save.add(key);
				}
			}
		}
		return save.size();
	}
	
	private static Map<String, Integer> getMapStr(List<String> list){
		Map<String, Integer> map = new HashMap<>();
		for (String str1 : list) {
			String str = str1.toLowerCase();
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}
			else {
				map.put(str, 1);
			}
		}
		return map;
	}
}
