package programmers.lv_1.���ڹ��ڿ���_���ܾ�;

/* 
 * �Ͻ� : 2021.12.05
 * ������ : ���ڹ��ڿ��� ���ܾ�
 * ���̵� : �ڡ�
 * ����� ���� : 	input					output
 * 				"one4seveneight"		1478
 * 				"23four5six7"			234567
 * 				"2three45sixseven"		234567
 * 				"123"					123
 * ��� : 
 */
public class BestSolution {
	/*
	 * Point 1. replaceAll ���!
	 * 
	 * */
	public int solution(String s) {
		String[] numbers = {"zero", "one", "two", "three", "four","five", "six", "seven", "eight", "nine"};
		
		for (int i = 0; i < numbers.length; i++) {
			s = s.replaceAll(numbers[i], String.valueOf(i));
		}
		
		return Integer.parseInt(s);
	}
}
