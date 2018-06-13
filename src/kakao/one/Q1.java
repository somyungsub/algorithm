package kakao.one;

public class Q1 {

	public static void main(String[] args) {
		
		int[] arr1 = new int[] {9, 20, 28, 18, 11};
		int[] arr2 = new int[] {30, 1, 21, 17, 28};
		int[] arr3 = new int[] {46, 33, 33 ,22, 31, 50};
		int[] arr4 = new int[] {27 ,56, 19, 14, 14, 10};
		
		show(arr1,arr2);
		System.out.println("------------------------");
		show(arr3,arr4);
		
		
	}
	
	private static void show(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			StringBuffer sb = new StringBuffer();
			int bit = arr1[i]|arr2[i];
			while (bit > 0) {
				sb.append(bit % 2  == 1 ? "#" : " ");
				bit = bit >> 1;
			}
			sb.reverse().append(System.lineSeparator());
			System.out.print(sb.toString());
		}
	}
}
