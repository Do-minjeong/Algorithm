package programmers.lv_2.�Ƿε�;

import java.util.Arrays;
import java.util.Iterator;

/**
 * �Ͻ� : 2021. 12. 18. ���� 9:52:09
 * ������ : �Ƿε�
 * ���̵� : ��
 * ����� ���� : 	input01		 input02						output
 * 		 		80			 [[80,20],[50,40],[30,10]]		3
 * ��� :
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
