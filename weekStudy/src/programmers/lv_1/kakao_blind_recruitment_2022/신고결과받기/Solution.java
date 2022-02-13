package programmers.lv_1.kakao_blind_recruitment_2022.신고결과받기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 일시 : 2022. 2. 13. 오전 1:22:34
 * 문제명 : 신고 결과 받기
 * 난이도 : ★★
 * 입출력 예시 : 	input01									input02																	input03		output
 * 				["muzi", "frodo", "apeach", "neo"]		["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]		2			[2,1,1,0]
 * 				["con", "ryan"]							["ryan con", "ryan con", "ryan con", "ryan con"]						3			[0,0]
 * 				
 * 비고 :  
 */
public class Solution {
	 public int[] solution(String[] id_list, String[] report, int k) {
		 	System.out.println("==================================== start ===================================");
		 	int idLen = id_list.length;
	        int[] answer = new int [idLen];
	        boolean[][] report_list = new boolean[idLen][idLen];
	        
	        Map<String, Integer> id_map = new HashMap<String, Integer>();
	        for (int i = 0; i < idLen; i++) {
				id_map.put(id_list[i], i);
			}
	        HashSet<String> set = new HashSet<String>(Arrays.asList(report));
	        Iterator<String> ir = set.iterator();
	        
	        while (ir.hasNext()) {
				String user = (String) ir.next();
				String[] id = user.split(" ");
				int i = id_map.get(id[0]);
				int j = id_map.get(id[1]);
				report_list[i][j] = true;	
			}
	        
	        boolean[] stop_user = new boolean[idLen];
	        for (int i = 0; i < idLen; i++) {
	        	int ksum = 0;
	        	for (int j = 0; j < idLen; j++) {
	        		if(i==j) continue;
	        		if(ksum >= k) break;
	        		if(report_list[j][i]) ksum++;
				}
	        	if(ksum >= k) stop_user[i] = true;
			}
	        
	        for (int i = 0; i < idLen; i++) {
	        	for(int j = 0; j < idLen; j++) {
	        		if(i==j) continue;
	        		if(report_list[i][j] && stop_user[j]) answer[i]++;
	        	}
			}
	        
	        return answer;
	 }
}
