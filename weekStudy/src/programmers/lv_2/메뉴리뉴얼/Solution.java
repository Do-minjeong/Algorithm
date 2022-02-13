package programmers.lv_2.메뉴리뉴얼;

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
public class Solution {
	public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (int i = 0; i < orders.length; i++) {
    		detailSolution(orders[i], i+1, orders);
		}
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> menuMap >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return answer;
    }
	
	public void detailSolution(String order01, int idx, String[] orders) {
	
	}
}
