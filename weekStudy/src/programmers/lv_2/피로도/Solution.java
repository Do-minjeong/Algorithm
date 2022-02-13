package programmers.lv_2.피로도;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 일시 : 2021. 12. 18. 오후 9:52:09
 * 문제명 : 피로도
 * 난이도 : ★
 * 입출력 예시 : 	input01		 input02						output
 * 		 		80			 [[80,20],[50,40],[30,10]]		3
 * 비고 :
 */
public class Solution {
	int max = 0;
	public int solution(int k, int[][] dungeons) {

		boolean[] isVisited = new boolean[dungeons.length];
		func(dungeons, isVisited, k, 1);

		return max;
	}

	public void func(int[][] dungeons, boolean[] isVisited, int k, int n) {
		
	}

}
