package programmers.lv_2.ĳ��;

import java.util.ArrayList;
import java.util.List;

/* 
 * �Ͻ� : 2022.07.04
 * ������ : 2018 KAKAO BLIND RECRUITMENT - [1��] ĳ��
 * ���̵� : ��
 * ����� ���� : 	
 * input01	input02																												output
 * 	3		["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]							50
 * 	3		["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]									21
 * 	2		["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	60
 * 	5		["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	52
 * 	2		["Jeju", "Pangyo", "NewYork", "newyork"]																			16
 * 	0		["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]																		25
 * ��� : LRU �˰��� ����(Least Recently Used) ���� �������� �������� ���� �������� ��ü�ϴ� ���. cache hit�� ��� 1�� cache miss�� ��� 5�� 
 */
public class Solution {
	public void execute() {
		int cacheSize01 = 3;
		String[] cities01 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int cacheSize02 = 3;
		String[] cities02 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		int cacheSize03 = 2;
		String[] cities03 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		int cacheSize04 = 5;
		String[] cities04 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		int cacheSize05 = 2;
		String[] cities05 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		int cacheSize06 = 0;
		String[] cities06 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		System.out.println("==================== ex1 ====================");
		System.out.println(solution(cacheSize01, cities01));
		System.out.println("==================== ex2 ====================");
		System.out.println(solution(cacheSize02, cities02));
		System.out.println("==================== ex3 ====================");
		System.out.println(solution(cacheSize03, cities03));
		System.out.println("==================== ex4 ====================");
		System.out.println(solution(cacheSize04, cities04));
		System.out.println("==================== ex5 ====================");
		System.out.println(solution(cacheSize05, cities05));
		System.out.println("==================== ex6 ====================");
		System.out.println(solution(cacheSize06, cities06));
		
	}
	
	public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;
        int hitTime = 1, missTime = 5; 
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < cities.length; i++) {
        	String city = cities[i].toUpperCase();
        	if(cacheSize > 0) {
        		if(list.contains(city)) {		/* hit! */
        			totalTime += hitTime;
        			list.remove(city);
        			list.add(city);
        		} else {						/* miss! */
        			totalTime += missTime;
        			if( list.size() >= cacheSize) {
        				list.remove(0);
        			}
        			list.add(city);
        		}
        	} else {
        		totalTime += missTime;
        	}
		}
        return totalTime;
    }
}
