package programmers.execute;

import java.util.Arrays;

/**
 * �Ͻ� : 2022. 2. 13. ���� 1:06:09
 * ��� : ���� ���� �޼ҵ�
 */
public class SolutionList {
	/*
	 * LEVEL : 1
	 * ������  : ���ڹ��ڿ��� ���ܾ�
	 * */
	public void ���ڹ��ڿ���_���ܾ�() {
		programmers.lv_1.���ڹ��ڿ���_���ܾ�.Solution s = new programmers.lv_1.���ڹ��ڿ���_���ܾ�.Solution();
		programmers.lv_1.���ڹ��ڿ���_���ܾ�.BestSolution bs = new programmers.lv_1.���ڹ��ڿ���_���ܾ�.BestSolution();
		
		String[] input = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};
		for (int i = 0; i < input.length; i++) {
			System.out.println("in: "+ input[i] + ", out: " + s.solution(input[i]));
			System.out.println("in: "+ input[i] + ", out: " + bs.solution(input[i]));
		}
	}
	/*
	 * LEVEL : 1
	 * ������ : �Ű����ޱ�
	 * ��    : [2,1,1,0] , [0,0]
	 * */
	public static void �Ű����ޱ�() {
		programmers.lv_1.kakao_blind_recruitment_2022.�Ű����ޱ�.Solution s = new programmers.lv_1.kakao_blind_recruitment_2022.�Ű����ޱ�.Solution();
		
		String[][] input01 = {{"muzi", "frodo", "apeach", "neo"}, {"con", "ryan"} };
		String[][] input02 = {{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, {"ryan con", "ryan con", "ryan con", "ryan con"} };
		int[] input03 = {2,3};
		
		for (int i = 0; i < input01.length; i++) {
			System.out.println(Arrays.toString(s.solution(input01[i], input02[i], input03[i])));
		}
	}
	/*
	 * LEVEL : 2
	 * ������ : �Ƿε�
	 * */
	public static void �Ƿε�() {
		programmers.lv_2.�Ƿε�.Solution s = new programmers.lv_2.�Ƿε�.Solution();
		int input01 = 80;
		int[][] input02 = {{80,20},{50,40},{30,10}};

		System.out.println(s.solution(input01, input02));

	}
	/*
	 * LEVEL : 2
	 * ������ : ����ä�ù�
	 * */
	public static void ����ä�ù�() {
		programmers.lv_2.����ä�ù�.Solution s = new programmers.lv_2.����ä�ù�.Solution();
		
		String[] input = {"Enter uid1234 Muzi"
						, "Enter uid4567 Prodo"
						, "Leave uid1234"
						, "Enter uid1234 Prodo"
						, "Change uid4567 Ryan" };
		
		System.out.println(Arrays.toString(s.solution(input)));
	}
	/*
	 * LEVEL : 2
	 * ������ : �޴�������
	 * */
	public void �޴�������() {
		programmers.lv_2.�޴�������.Solution s = new programmers.lv_2.�޴�������.Solution();
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
