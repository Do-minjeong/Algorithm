package programmers.lv_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 일시 : 2021. 12. 5. 오후 8:39:32
 * 문제명 : 메뉴 리뉴얼
 * 난이도 : ★★★★★★★★★
 * 입출력 예시 : 	input01												input02		output
 * 				["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]		[2,3,4]		["AC", "ACDE", "BCFG", "CDE"]
 * 				["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]		["ACD", "AD", "ADE", "CD", "XYZ"]
 * 				["XYZ", "XWY", "WXA"]								[2,3,4]		["WX", "XY"]
 * 비고 : 
 */
public class MenuRenewal {
	public static void main(String[] args) {
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
			System.out.println(solution(input[i], input02[i]));
		}
	}
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (int i = 0; i < orders.length; i++) {
    		detailSolution(orders[i], i+1, orders);
		}
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> menuMap >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return answer;
    }
	
	public static void detailSolution(String order01, int idx, String[] orders) {
	
	}
}
