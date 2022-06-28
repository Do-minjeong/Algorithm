package programmers.lv_2.¦���������ϱ�;

import java.util.Stack;

/* 
 * �Ͻ� : 2022.06.28
 * ������ : ¦���������ϱ�
 * ���̵� : �ڡ�
 * ����� ���� : 	input					output
 * 				"baabaa"				1
 * 				"cdcd"					0
 * 				"abcda"					0
 * ��� : stack�� ����Ͽ� ¦���� ���� ������ ��� 1 return �Ұ����� ��� 0 return
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
