package programmers.lv_2;

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
public class Pirodo {
	public static void main(String[] args) {
		int input01 = 80;
		int[][] input02 = {{80,20},{50,40},{30,10}};

		System.out.println(solution(input01, input02));

	}
	static int max = 0;
	public static int solution(int k, int[][] dungeons) {

		boolean[] isVisited = new boolean[dungeons.length];
		func(dungeons, isVisited, k, 1);

		return max;
	}

	public static void func(int[][] dungeons, boolean[] isVisited, int k, int n) {
		
	}

}
