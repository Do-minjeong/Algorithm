package programmers.lv_2.���ϸ�����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
 * �Ͻ� : 2022.07.05
 * ������ : 2018 KAKAO BLIND RECRUITMENT - [3��] ���ϸ� ����
 * ���̵� : �ڡ�
 * ����� ���� : 	
 * input01																				output
 * ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]			["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
 * ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"] 	["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
 * ��� : ���ϸ��� head, number, tail�� ������ head�� number ������ �����Ѵ�. ��ҹ��ڱ������� ������ head�� number�� ���� ��� �����Էµ� ������� ����.
 */
public class Solution {
	public void execute() {
		String[] input01 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] input02 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] input03 = {"foo010bar020.zip", "foo01bar230.zip","abc1235015defg123.jpg","abc123491defg123.jpg"};
		String[] input04 = {"qa12","fe12","qa31"};
		/*System.out.println(Arrays.toString(solution(input01)));
		System.out.println(Arrays.toString(solution(input02)));
		System.out.println(Arrays.toString(solution(input03)));*/
		System.out.println(Arrays.toString(solution(input04)));
	}
	
	public String[] solution(String[] files) {
		String[] answer = new String[files.length];
		List<FileName> fileList = new ArrayList<FileName>();
		for (int i = 0; i < files.length; i++) {
			FileName fn = new FileName(i, files[i]);
			fileList.add(fn);
		}
		
		/* ���ϸ���Ʈ ���� */
		Collections.sort(fileList, new Comparator<FileName>() {
			@Override
			public int compare(FileName o1, FileName o2) {
				/* ���ذ��� �񱳴�󺸴� ū ��� 1 */
				int c1 = o1.head.compareToIgnoreCase(o2.head);
				if(c1 == 0) {
					int c2 = o1.number - o2.number;
					if(c2 == 0) 	return o1.fileNo - o2.fileNo;
					else 			return c2;
					
				} else		return c1;
			}
	    });
		
		/* List -> Array�� */
		for (int i = 0; i < answer.length; i++) answer[i] = fileList.get(i).getOrgFileName();
		
		return answer;
	}
	
	class FileName {
		private String orgFileName, head, tail;
		private int fileNo, number;
		private int startIdx, endIdx;
		
		public FileName(int fileNo, String fileName) {
			String tmpFileName = fileName.toUpperCase();
			saveIndex(tmpFileName);
			this.fileNo = fileNo;
			this.orgFileName = fileName;
			this.head = tmpFileName.substring(0, this.startIdx);
			this.number = Integer.parseInt(tmpFileName.substring(startIdx, this.endIdx));
			this.tail = tmpFileName.substring(this.endIdx);
		}
		/* ���ϸ� substring �� index ���ϱ� */
		private void saveIndex(String tmpFileName) {
			this.startIdx = 0;
			this.endIdx = 0;
			for (int i = 0; i < tmpFileName.length(); i++) {
				if(this.startIdx > 0 && this.endIdx > 0) break;
				char s = tmpFileName.charAt(i);
				if(this.startIdx == 0 && Character.isDigit(s)) 
					this.startIdx = i;
				else if(this.startIdx > 0 && this.endIdx == 0 && (!Character.isDigit(s) || i-this.startIdx > 4) )
					this.endIdx = i;
			}
			if(this.endIdx == 0) this.endIdx = tmpFileName.length();
		}
		
		public String getOrgFileName() {
			return orgFileName;
		}

		@Override
		public String toString() {
			/*return "FileName [fileNo=" + fileNo + ", orgFileName=" + orgFileName + ", head=" + head + ", tail=" + tail
					+ ", number=" + number + "]";*/
			return orgFileName;
		}
		
		
	}
}
