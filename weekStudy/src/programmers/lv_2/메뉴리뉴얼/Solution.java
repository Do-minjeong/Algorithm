package programmers.lv_2.메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 일시 : 2021. 12. 5. 오후 8:39:32
 * 문제명 : 메뉴 리뉴얼
 * 난이도 : ★★★★★
 * 입출력 예시 : 	input01												input02		output
 * 				["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]		[2,3,4]		["AC", "ACDE", "BCFG", "CDE"]
 * 				["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]		["ACD", "AD", "ADE", "CD", "XYZ"]
 * 				["XYZ", "XWY", "WXA"]								[2,3,4]		["WX", "XY"]
 * 비고 : 
 */
public class Solution {
	
	public void execute() {
		String[] orders01 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course01 = {2,3,4};
		String[] orders02 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course02 = {2,3,5};
		String[] orders03 = {"XYZ", "XWY", "WXA"};
		int[] course03 = {2,3,4};
		
		System.out.println(Arrays.toString(solution(orders01, course01)));
		System.out.println(Arrays.toString(solution(orders02, course02)));
		System.out.println(Arrays.toString(solution(orders03, course03)));
		
	}
	
	Map<String, Integer> map = null;
	
	public String[] solution(String[] orders, int[] course) {
        List<String> outList = new ArrayList<String>();
        
        // course 반복문
        for (int i=0; i < course.length; i++) {
        	map = new HashMap<String, Integer>();
        	// orders 반복문
        	for(int j=0; j < orders.length; j++) {
        		String[] target = orders[j].split("");
        		Arrays.sort(target);
        		menuCombi(target, new boolean[target.length], 0, 0, course[i]);
        	}
        	List<String> rsltList = getMenuMaxValue(map);
        	outList.addAll(rsltList);
		}
        
        String[] answer = outList.toArray(new String[outList.size()]);
        Arrays.sort(answer);
        
        return answer;
    }
	
	/* 
	 * Fuction 
	 * Name : menuCombi (메뉴 조합 구하기) 
	 * Parameters : target(메뉴 배열), visited(메뉴선택여부), start(시작할 인덱스), cntNum(선택한메뉴개수), combNum(선택할메뉴개수)
	 * */
	public void menuCombi(String[] target, boolean[] visited, int start, int cntNum, int combNum) {
		if(cntNum == combNum) {
			String courseKey = makeCourse(target, visited);
			int courseVal = !map.containsKey(courseKey) ? 1 : map.get(courseKey)+1;
			map.put(courseKey, courseVal);
			return;
		}
		
		for (int i = start; i < target.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				menuCombi(target, visited, (i+1), cntNum+1, combNum);
				visited[i] = false;
			}
		}
	}
	
	/* 
	 * Fuction 
	 * Name : makeCourse (선택된 메뉴 코스 맞들기) 
	 * Parameters : target(메뉴 배열), visited(메뉴선택여부)
	 * */
	public String makeCourse(String[] target, boolean[] visited) {
		String course = "";
		for (int i = 0; i < target.length; i++) {
			if(visited[i]) course += target[i];
		}
		return course;
	}
	
	/* 
	 * Fuction 
	 * Name : getMenuMaxValue (메뉴 조합 중 가장 많이 주문된 조합 구하기) 
	 * Parameters : map(모든메뉴조합)
	 * */
	public List<String> getMenuMaxValue(Map<String, Integer> map) {
		List<String> out = new ArrayList<String>();
		if(map.size() <= 0) return out;
		
		/* map 정렬 by value*/
		List<Map.Entry<String, Integer>> entries = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(entries, (o1,o2) -> o2.getValue().compareTo(o1.getValue()));
		int max = entries.get(0).getValue();
		if(max < 2) return out;
		
		for (int i = 0; i < entries.size(); i++) {
			int value = entries.get(i).getValue();
			if(max > value) break;
			out.add(entries.get(i).getKey());
		}
		
		return out;
	}
}
