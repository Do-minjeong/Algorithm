package programmers.lv_1.폰켓몬;

import java.util.HashSet;
import java.util.Set;

/* 
 * 일시 : 2022.06.27
 * 문제명 : 폰켓몬
 * 난이도 : ★
 * 입출력 예시 : 	input					output
 * 				{3,1,2,3}				2
 * 				{3,3,3,2,2,4}			3
 * 				{3,3,3,2,2,2}			2 
 * 비고 : 
 */

public class Solution {

	public void execute() {
		int[] nums1 = {3,1,2,3};
		int[] nums2 = {3,3,3,2,2,4};
		int[] nums3 = {3,3,3,2,2,2};
		
		System.out.println("============== solution 1 =============");
		System.out.println(solution(nums1));
		System.out.println("============== solution 2 =============");
		System.out.println(solution(nums2));
		System.out.println("============== solution 3 =============");
		System.out.println(solution(nums3));
	}
	
	public int solution(int[] nums) {
		int answer = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int n : nums) {
			set.add(n);
		}
		
		if(set.size() < nums.length/2) 	answer = set.size();
		else							answer = nums.length/2;
		
		return answer;
	}
}
