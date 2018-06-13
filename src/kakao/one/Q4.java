package kakao.one;

import java.text.SimpleDateFormat;

public class Q4 {

	public static void main(String[] args) {
		/*
		 * 셔틀은 09:00부터 총 n회 t분 간격으로 역에 도착하며, 하나의 셔틀에는 최대 m명의 승객이 탈 수 있다.
		 * 
		 * 셔틀은 도착했을 때 도착한 순간에 대기열에 선 크루까지 포함해서 대기 순서대로 태우고 바로 출발한다. 
		 * 예를 들어 09:00에 도착한 셔틀은 자리가 있다면 09:00에 줄을 선 크루도 탈 수 있다.
		 * 
		 * 도착 시각 중 제일 늦은 시각을 구하여라. 같은 시각에 도착한 크루 중 대기열에서 제일 뒤에 선다 모든 크루는 잠을 자야 하므로
		 * 23:59에 집에 돌아간다 -> 따라서 어떤 크루도 다음날 셔틀을 타는 일은 없다.
		 * 
		 * In
		 * 	셔틀 운행 횟수 n, 셔틀 운행 간격 t, 한 셔틀에 탈 수 있는 최대 크루 수 m, 크루가 대기열에 도착하는 시각을 모은 배열
		 * 	timetable이 입력으로 주어진다. 
		 * 	0 ＜ n ≦ 10 
		 * 	0 ＜ t ≦ 60 
		 * 	0 ＜ m ≦ 45
		 * 
		 * OUT
		 * 	셔틀을 타고 사무실로 갈 수 있는 제일 늦은 도착 시각을 출력한다. 도착 시각은 HH:MM 형식
		 */
		
		String[] strs = new String[] {"08:00", "08:01", "08:02", "08:03"}; // 1,1,5
		
		show(strs);

	}
	
	private static void show(String[] strs) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
		sdf.format(new java.util.Date());
		String maxTime = "";
		
		System.out.println(sdf.toString());
		
	}

}
