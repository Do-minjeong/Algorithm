package programmers.lv_2.짝지어제거하기;

import java.util.Stack;

/* 
 * 일시 : 2022.06.28
 * 문제명 : 짝지어제거하기
 * 난이도 : ★★
 * 입출력 예시 : 	input					output
 * 				"baabaa"				1
 * 				"cdcd"					0
 * 				"abcda"					0
 * 비고 : stack을 사용하여 짝지어 제거 가능한 경우 1 return 불가능할 경우 0 return
 */
public class Solution {
	public void execute() {
		String s1 = "baabaa";
		String s2 = "cdcd";
		String s3 = "abcda";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
	}
	
	public int solution(String s) {
		Stack<String> st = new Stack<String>();
		
		for (int i = 0; i < s.length(); i++) {
			String str = String.valueOf(s.charAt(i));
			if(st.empty()) st.add(str);
			else {
				if(st.peek().equals(str)) 	st.pop();
				else 						st.add(str);
			}
			System.out.println(st);
		}
		
		return st.size() > 0 ? 0 : 1;
	}
}
