package kakao.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Q3 {
	public static void  main(String args[]) {
		String[] strs1 = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		String[] strs2 = new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		String[] strs3 = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		String[] strs4 = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		String[] strs5 = new String[] {"Jeju", "Pangyo", "NewYork", "newyork"};
		String[] strs6 = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		System.out.println("1.실행시간 : " + getExeTime(strs1, 3));
		System.out.println("2.실행시간 : " + getExeTime(strs2, 3));
		System.out.println("3.실행시간 : " + getExeTime(strs3, 2));
		System.out.println("4.실행시간 : " + getExeTime(strs4, 5));
		System.out.println("5.실행시간 : " + getExeTime(strs5, 2));
		System.out.println("6.실행시간 : " + getExeTime(strs6, 0));
	}
	
	// 실행시간얻기
	private static int getExeTime(String[] strs, int casheSize) {
		int totalTime = 0;
		Map<String, Integer> map = new HashMap<>();
		
		// LRU
		for (String str : strs) {
			
			if(map.containsKey(str.toLowerCase())) {
				totalTime += 1;
				map.put(str.toLowerCase(), 0);
			}
			else {
				totalTime += 5;
				map.put(str.toLowerCase(), 0);
				if(map.size() > casheSize) {
					removeCashe(map);
				}
				
			}
			increaseValue(map);
		}
		return totalTime;
	}
	

	private static void increaseValue(Map<String, Integer> map) {
		for (Entry<String, Integer> entry : map.entrySet()) {
			map.put(entry.getKey(), entry.getValue()+1);
		}
	}

	private static void removeCashe(Map<String, Integer> map) {
		int max = 0;
		String key = "";
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if(max < value) {
				max = value;
				key = entry.getKey();
			}
		}
		
		map.remove(key);
	}

}
