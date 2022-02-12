package programmers.lv_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
 * �Ͻ� : 2021.12.05
 * ������ : ����ä�ù�
 * ���̵� : �ڡ�
 * ����� ���� : 	input					output
 *  input  > ["Enter uid1234 Muzi"		["Prodo���� ���Խ��ϴ�."
 *  		, "Enter uid4567 Prodo"		, "Ryan���� ���Խ��ϴ�."
 *  		,"Leave uid1234"			, "Prodo���� �������ϴ�."
 *  		,"Enter uid1234 Prodo"		, "Prodo���� ���Խ��ϴ�."]
 *  		,"Change uid4567 Ryan"]
 * ��� : 
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
		msgMap.put("Enter", "���� ���Խ��ϴ�.");
		msgMap.put("Leave", "���� �������ϴ�.");
		
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

