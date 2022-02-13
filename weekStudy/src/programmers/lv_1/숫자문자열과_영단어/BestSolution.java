package programmers.lv_1.숫자문자열과_영단어;

/* 
 * 일시 : 2021.12.05
 * 문제명 : 숫자문자열과 영단어
 * 난이도 : ★★
 * 입출력 예시 : 	input					output
 * 				"one4seveneight"		1478
 * 				"23four5six7"			234567
 * 				"2three45sixseven"		234567
 * 				"123"					123
 * 비고 : 
 */
public class BestSolution {
	/*
	 * Point 1. replaceAll 사용!
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
