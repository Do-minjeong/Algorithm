package programmers.lv_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
 * 일시 : 2021.12.05
 * 문제명 : 오픈채팅방
 * 난이도 : ★★
 * 입출력 예시 : 	input					output
 *  input  > ["Enter uid1234 Muzi"		["Prodo님이 들어왔습니다."
 *  		, "Enter uid4567 Prodo"		, "Ryan님이 들어왔습니다."
 *  		,"Leave uid1234"			, "Prodo님이 나갔습니다."
 *  		,"Enter uid1234 Prodo"		, "Prodo님이 들어왔습니다."]
 *  		,"Change uid4567 Ryan"]
 * 비고 : 
 */
public class OpenChat {

	public static void main(String[] args) {
		String[] input = {"Enter uid1234 Muzi"
						, "Enter uid4567 Prodo"
						, "Leave uid1234"
						, "Enter uid1234 Prodo"
						, "Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(input)));
		
	}
	
	public static String[] solution(String[] record) {
		Map<String, String> msgMap = new HashMap<String, String>();
		msgMap.put("Enter", "님이 들어왔습니다.");
		msgMap.put("Leave", "님이 나갔습니다.");
		
		Map<String, String> userMap = new HashMap<String, String>();
		for (String rec : record) {
			if(rec.indexOf("Leave") != 0) {
				String[] arr = rec.split(" ");
				userMap.put(arr[1], arr[2]);
			}
		}
		
		List<String> list = new ArrayList<String>();
		
		for (String rec : record) {
			String[] arr = rec.split(" ");
			
			if("Change".equals(arr[0])) {
				continue;
			}
			
			String outMsg = userMap.get(arr[1]) + msgMap.get(arr[0]);
			list.add(outMsg);
		}
		
		return list.toArray(new String[list.size()]);
	}
}

