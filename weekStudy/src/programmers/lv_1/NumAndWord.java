package programmers.lv_1;

import java.util.Iterator;

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
public class NumAndWord {

	public static void main(String[] args) {
		String[] input = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};
		for (int i = 0; i < input.length; i++) {
			System.out.println(solution(input[i]));
			System.out.println(best_solution(input[i]));
		}
		
	}
	/*
	 * Point 1. replaceAll 사용!
	 * 
	 * */
	public static int best_solution(String s) {
		String[] numbers = {"zero", "one", "two", "three", "four","five", "six", "seven", "eight", "nine"};
		
		for (int i = 0; i < numbers.length; i++) {
			s = s.replaceAll(numbers[i], String.valueOf(i));
		}
		
		return Integer.parseInt(s);
	}
	
	public static int solution(String s) {
		String out = "";
		StringBuffer sb = new StringBuffer(s);
		
		while(sb.length() > 0) {
			char ch = sb.charAt(0);
			if(48 <= ch && ch <= 57) {
				sb.deleteCharAt(0);
				out += ch;
			} else {
				String[] rslt = strToNum(sb.toString());
				sb.delete(0, Integer.parseInt(rslt[0]));
				out += rslt[1];
			}
		}
		return Integer.parseInt(out);
	}
	
	
	public static String[] strToNum(String s) {
		String[] strNums = {"zero", "one", "two", "three", "four","five", "six", "seven", "eight", "nine"};
		String[] out = new String[2];
		
		for (int i = 0; i < strNums.length; i++) {
			if(s.indexOf(strNums[i]) == 0) {
				out[0] = String.valueOf(strNums[i].length());
				out[1] = String.valueOf(i);
				break;
			} else {
				continue;
			}
		}
		
		return out;
	}
}
