package programmers.lv_2.압축;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* 
 * 일시 : 2022.07.05
 * 문제명 : 2018 KAKAO BLIND RECRUITMENT - [3차] 압축
 * 난이도 : ★★
 * 입출력 예시 : 	
 * input01							output
 * "KAKAO"							{11, 1, 27, 15}
 * "TOBEORNOTTOBEORTOBEORNOT"		{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}
 * "ABABABABABABABAB"				{1, 2, 27, 29, 28, 31, 30}
 * 비고 : LZW(Lempel-Ziv-Welch) 압축 
 *	 1. 길이가 1인 모든 단어를 포함사도록 사전을 초기화한다. (문제에서 A~Z)
 *	 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
 *	 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
 *	 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
 *	 5. 단계 2로 돌아간다.
 */
public class Solution {

	public void execute() {
		String msg1 = "KAKAO";
		String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
		String msg3 = "ABABABABABABABAB";
		
		System.out.println(Arrays.toString(solution(msg1)));
		System.out.println(Arrays.toString(solution(msg2)));
		System.out.println(Arrays.toString(solution(msg3)));
	}
	
	public int[] solution(String msg) {
		List<Integer> idxList = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<>();
		
		char capA = 'A';
		for (int i = 0; i < 26; i++) {
			char key = (char) (capA + i);
			map.put(String.valueOf(key), i+1);
		}
		
		Queue<String> msgList = new LinkedList<String>();
		for (int i = 0; i < msg.length(); i++) {
			msgList.add(String.valueOf(msg.charAt(i)));
		}
		
		boolean flag = false;
		String oldWord = "", newWord = "";
		while(!msgList.isEmpty()) {
			oldWord += msgList.peek()==null? "" : msgList.peek();
			if(map.containsKey(oldWord)) {
				flag = true;
				newWord += msgList.poll();
			} else {
				flag = false;
			}

			if(!flag || msgList.isEmpty()) {
				idxList.add(map.get(newWord));
				if(!oldWord.equals(newWord)) map.put(oldWord, map.size()+1);
				oldWord = "";
				newWord = "";
			}
		}
		
		int[] answer = new int[idxList.size()];
		for (int i = 0; i < idxList.size(); i++) {
			answer[i] = idxList.get(i);
		}
		
		return answer;
	}
}
