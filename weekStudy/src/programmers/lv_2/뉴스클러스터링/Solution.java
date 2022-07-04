package programmers.lv_2.����Ŭ�����͸�;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
 * �Ͻ� : 2022.07.04
 * ������ : ����Ŭ�����͸�
 * ���̵� : �ڡڡ�
 * ����� ���� : 	input01			input02				output
 * 				"FRANCE"		"french"			16384
 * 				"handshake"		"shake hands"		65536
 * 				"aa1+aa2"		"AAAA12"			43690
 * 				"E=M*C^2"		"e=m*c^2"			65536
 * 				"abc"			"abbb"				16384
 * ��� : ���ڿ��� �ΰ��� �ڸ� �� �迭���� �����հ� �������� ���� �� ��ī�� ���絵�� ���Ѵ�. 
 * 		��ī�� ���絵 = ������ ���Ұ���/������ ���Ұ���
 * 		��ī�� ���絵 * 65536 �Ҽ����� ��� ���� �� ����Ѵ�.
 */
public class Solution {

	public void execute() {
		String str01 = "FRANCE";
		String str02 = "french";
		String str03 = "handshake";
		String str04 = "shake hands";
		String str05 = "aa1+aa2";
		String str06 = "AAAA12";
		String str07 = "E=M*C^2";
		String str08 = "e=m*c^2";
		String str09 = "di mi mi mi mi";
		String str10 = "di di di go";
		String str11 = "abc";
		String str12 = "abbb";
		
/*		System.out.println("================= ex1 ===================");
		System.out.println(solution(str01, str02));
		System.out.println("================= ex2 ===================");
		System.out.println(solution(str03, str04));
		System.out.println("================= ex3 ===================");
		System.out.println(solution(str05, str06));
		System.out.println("================= ex4 ===================");
		System.out.println(solution(str07, str08));
		System.out.println("================= ex5 ===================");
		System.out.println(solution(str09, str10));*/
		System.out.println("================= ex6 ===================");
		System.out.println(solution(str11, str12));
	}
	/*
	 * ���� �Լ�
	 * */	
	public int solution(String str1, String str2) {
		Map<String, Integer> map1 = makeMap(str1);
		Map<String, Integer> map2 = makeMap(str2);
		
		double out = 0;
		int unionCnt = makeUnion(map1, map2);
		int interSectionCnt = 0;
		if(unionCnt == 0) out = 1;
		else {
			interSectionCnt = makeInterSection(map1, map2);
			out = (double) interSectionCnt/unionCnt;
		}
		
		return (int) Math.floor(out*65536);
	}
	
	/*
	 * ������ ���Ұ��� ���ϱ�
	 * */
	private int makeUnion(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> c1 = new HashMap<String, Integer>();
		c1.putAll(map1);

		int out = 0;
		Iterator<String> map2ir = map2.keySet().iterator();
		while(map2ir.hasNext()) {
			String key = map2ir.next();

			if(c1.containsKey(key))
				c1.put(key, c1.get(key) > map2.get(key) ? c1.get(key) : map2.get(key));
			else						
				c1.put(key, map2.get(key));
		}
		Iterator<String> c1ir = c1.keySet().iterator();
		
		while(c1ir.hasNext()) {
			String key = c1ir.next();
			
			out += c1.get(key);
		}

		return out;
	}
	
	/*
	 * ������ ���Ұ��� ���ϱ� 
	 * */
	private int makeInterSection(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> c1 = map1.size() >= map2.size() ? map1 : map2;
		Map<String, Integer> c2 = map1.size() < map2.size() ? map1 : map2;
		int out = 0;
		Iterator<String> ir = c1.keySet().iterator();
		while(ir.hasNext()) {
			String key = ir.next();
			if(c2.containsKey(key)) {
				int value = c1.get(key) < c2.get(key) ? c1.get(key) : c2.get(key);
				out += value;
			}
		}
		return out;
	}

	/*
	 * ���ڿ� ���� �����
	 * */
	public Map<String, Integer> makeMap(String str){
		Map<String, Integer> out = new HashMap<String, Integer>();
		str = str.toUpperCase();
		
		int idx1 = 0;
		while(true) {
			if(idx1 == str.length()-1) break;
			
			char s1 = str.charAt(idx1), s2 = str.charAt(idx1+1);
			if(65 <= s1 && 90 >= s1 && 65 <= s2 && 90 >= s2) {
				String key = s1 + "" + s2;
				if(out.containsKey(key))	out.put(key, out.get(key)+1);
				else 						out.put(key, 1);
			}
			idx1++;
		}
		
		return out;
	}
}
