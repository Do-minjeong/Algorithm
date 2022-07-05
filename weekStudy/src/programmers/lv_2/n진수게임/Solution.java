package programmers.lv_2.n진수게임;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 
 * 일시 : 2022.07.05
 * 문제명 : 2018 KAKAO BLIND RECRUITMENT - [3차] n진수게임
 * 난이도 : ★
 * 입출력 예시 : 	
 * input01		input02		input03		input04		output
 * 2			4			2			1			"0111"
 * 16			16			2			1			"02468ACE11111111"
 * 16			16			2			2			"13579BDF01234567"
 * 비고 : n=진법, t=미리 구할 숫자의 개수, m=게임에 참가하는 인원, p= 튜브의 순서
 */
public class Solution {

	public void execute() {
		int n1 = 2, t1 = 4, m1 = 2, p1 = 1;
		int n2 = 16, t2 = 16, m2 = 2, p2 = 1;
		int n3 = 16, t3 = 16, m3 = 2, p3 = 2;
		
		System.out.println(solution(n1, t1, m1, p1));
		System.out.println(solution(n2, t2, m2, p2));
		System.out.println(solution(n3, t3, m3, p3));
	}
	
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		Queue<String> que = new LinkedList<String>();
		int target = 0, no = 0;
		
		while(sb.length()<t) {
			no++;
			
			if(que.isEmpty()) {
				String str = Integer.toString(target, n).toUpperCase();
				que.addAll(Arrays.asList(str.split("")));
				target++;
			}
			
			if(no%m == p || (m==p && no%m == 0)) 	sb.append(que.poll());
			else 									que.poll();
		}
		
		return sb.toString();
	}
}
