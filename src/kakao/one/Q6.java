package kakao.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q6 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("CCBDE");
		list.add("AAADE");
		list.add("AAABF");
		list.add("CCBBF");
		answer(list);
	}
	
	private static void answer(List<String> list) {
		
		int result = 0;
		int size = list.size();
		Set<String> removeSet = new HashSet<>();
		
		while(true) {
			for (int i = 0; i < size-1; i++) {
				String str1 = list.get(i);
				String str2 = list.get(i+1);
				
				for (int j = 0; j < str1.length()-1; j++) {
					String str = String.valueOf(str1.charAt(j));
					if(!Character.isAlphabetic(str1.charAt(j))) {
						continue;
					}
					if(String.valueOf(str1.charAt(j+1)).equals(str)
							&& String.valueOf(str2.charAt(j)).equals(str)
							&& String.valueOf(str2.charAt(j+1)).equals(str)) {
						
						removeSet.add(""+i+""+j);
						removeSet.add(""+i+""+(j+1));
						removeSet.add(""+(i+1)+""+j);
						removeSet.add(""+(i+1)+""+(j+1));
					}
				}
			}
			result += removeSet.size();
			for (String str : removeSet) {
				int idx = Integer.parseInt(String.valueOf(str.charAt(0)));
				int at = Integer.parseInt(String.valueOf(str.charAt(1)));
				
				String s = list.get(idx);
				StringBuilder sb = new StringBuilder(s);
				sb.setCharAt(at, ' ');
				list.set(idx, sb.toString());
			}
			
			for (int i = 0; i < size-1; i++) {
				String ch1 = list.get(i);
				String ch2 = list.get(i+1);
				for (int j = 0; j < ch1.length(); j++) {
					String str = String.valueOf(ch2.charAt(j));
					if(" ".equals(str)) {
						StringBuilder sb = new StringBuilder(ch2);
						sb.setCharAt(j, ch1.charAt(j));
						list.set(i+1, sb.toString());
						
						StringBuilder sb2 = new StringBuilder(ch1);
						sb2.setCharAt(j, ' ');
						list.set(i, sb2.toString());
					}
				}
			}
			
			if(removeSet.isEmpty()) {
				break;
			}
			removeSet.clear();
		}
		
		System.out.println(result);
	}
}
