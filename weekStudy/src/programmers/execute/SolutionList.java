package programmers.execute;

import java.util.Arrays;

/**
 * 일시 : 2022. 2. 13. 오전 1:06:09
 * 비고 : 문제 실행 메소드
 */
public class SolutionList {
	/*
	 * LEVEL : 1
	 * 문제명  : 숫자문자열과 영단어
	 * */
	public void 숫자문자열과_영단어() {
		programmers.lv_1.숫자문자열과_영단어.Solution s = new programmers.lv_1.숫자문자열과_영단어.Solution();
		programmers.lv_1.숫자문자열과_영단어.BestSolution bs = new programmers.lv_1.숫자문자열과_영단어.BestSolution();
		
		String[] input = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};
		for (int i = 0; i < input.length; i++) {
			System.out.println("in: "+ input[i] + ", out: " + s.solution(input[i]));
			System.out.println("in: "+ input[i] + ", out: " + bs.solution(input[i]));
		}
	}
	/*
	 * LEVEL : 1
	 * 문제명 : 신고결과받기
	 * 답    : [2,1,1,0] , [0,0]
	 * */
	public static void 신고결과받기() {
		programmers.lv_1.kakao_blind_recruitment_2022.신고결과받기.Solution s = new programmers.lv_1.kakao_blind_recruitment_2022.신고결과받기.Solution();
		
		String[][] input01 = {{"muzi", "frodo", "apeach", "neo"}, {"con", "ryan"} };
		String[][] input02 = {{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, {"ryan con", "ryan con", "ryan con", "ryan con"} };
		int[] input03 = {2,3};
		
		for (int i = 0; i < input01.length; i++) {
			System.out.println(Arrays.toString(s.solution(input01[i], input02[i], input03[i])));
		}
	}
	/*
	 * LEVEL : 2
	 * 문제명 : 피로도
	 * */
	public static void 피로도() {
		programmers.lv_2.피로도.Solution s = new programmers.lv_2.피로도.Solution();
		int input01 = 80;
		int[][] input02 = {{80,20},{50,40},{30,10}};

		System.out.println(s.solution(input01, input02));

	}
	/*
	 * LEVEL : 2
	 * 문제명 : 오픈채팅방
	 * */
	public static void 오픈채팅방() {
		programmers.lv_2.오픈채팅방.Solution s = new programmers.lv_2.오픈채팅방.Solution();
		
		String[] input = {"Enter uid1234 Muzi"
						, "Enter uid4567 Prodo"
						, "Leave uid1234"
						, "Enter uid1234 Prodo"
						, "Change uid4567 Ryan" };
		
		System.out.println(Arrays.toString(s.solution(input)));
	}
	/*
	 * LEVEL : 2
	 * 문제명 : 메뉴리뉴얼
	 * */
	public void 메뉴리뉴얼() {
		programmers.lv_2.메뉴리뉴얼.Solution s = new programmers.lv_2.메뉴리뉴얼.Solution();
		String[][] input = {
							  {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}
							, {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}
							, {"XYZ", "XWY", "WXA"}
							};
		int[][] input02 = {
							  {2,3,4}
							, {2,3,5}
							, {2,3,4}
						  };
		
		for (int i = 0; i < 1; i++) {
			System.out.println("===================== "+ i + "===================== ");
			System.out.println(s.solution(input[i], input02[i]));
		}
	}
	
}
