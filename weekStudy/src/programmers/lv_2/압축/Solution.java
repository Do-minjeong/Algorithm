package programmers.lv_2.����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* 
 * �Ͻ� : 2022.07.05
 * ������ : 2018 KAKAO BLIND RECRUITMENT - [3��] ����
 * ���̵� : �ڡ�
 * ����� ���� : 	
 * input01							output
 * "KAKAO"							{11, 1, 27, 15}
 * "TOBEORNOTTOBEORTOBEORNOT"		{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}
 * "ABABABABABABABAB"				{1, 2, 27, 29, 28, 31, 30}
 * ��� : LZW(Lempel-Ziv-Welch) ���� 
 *	 1. ���̰� 1�� ��� �ܾ ���Ի絵�� ������ �ʱ�ȭ�Ѵ�. (�������� A~Z)
 *	 2. �������� ���� �Է°� ��ġ�ϴ� ���� �� ���ڿ� w�� ã�´�.
 *	 3. w�� �ش��ϴ� ������ ���� ��ȣ�� ����ϰ�, �Է¿��� w�� �����Ѵ�.
 *	 4. �Է¿��� ó������ ���� ���� ���ڰ� �����ִٸ�(c), w+c�� �ش��ϴ� �ܾ ������ ����Ѵ�.
 *	 5. �ܰ� 2�� ���ư���.
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
