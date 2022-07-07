package programmers.lv_2.방금그곡;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* 
 * 일시 : 2022.07.05
 * 문제명 : 2018 KAKAO BLIND RECRUITMENT - [3차] 방금그곡
 * 난이도 : ★
 * 입출력 예시 : 	
 * input01				input02															output
 * ABCDEFG				{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}		HELLO
 * CC#BCC#BCC#BCC#B		{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}		FOO
 * ABC					{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}		WORLD
 * 비고 : - input02배열의 문자열 의미 = 시작시간,끝난시간,음악젬고,악보정보
 * 		- 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개 이다.
 * 		- 각 음은 1분에 1개씩 재생된다.
 * 		- 조건에 일치하는 음악이 없을 때에는 "(None)"을 반환한다.
 */
public class Solution {

	public void execute() {
		String m1 = "ABCDEFG";
		String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF", "12:00,12:25,HELLO2,CDEFGAB"};
		String m2 = "CC#BCC#BCC#BCC#B";
		String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String m3 = "ABC";
		String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		System.out.println(solution(m1, musicinfos1));
		System.out.println(solution(m2, musicinfos2));
		System.out.println(solution(m3, musicinfos3));
	}
	
	public String solution(String m, String[] musicinfos) {
		String answer = "";
		List<MusicInfo> titleList = new ArrayList<>();
		m = melodyReplace(m);
		for (int i = 0; i < musicinfos.length; i++) {
			String[] musicInfo = musicinfos[i].split(",");
			musicInfo[3] = melodyReplace(musicInfo[3]);
			MusicInfo mi = new MusicInfo(musicInfo, i, m.length());
			if(mi.getPlayMelody().indexOf(m) > -1) titleList.add(mi);
		}
		
		Collections.sort(titleList, new Comparator<MusicInfo>() {
			@Override
			public int compare(MusicInfo o1, MusicInfo o2) {
				int c1 = o2.getPlayTime() - o1.getPlayTime();
				if(c1 == 0) {
					return o1.getNo() - o2.getNo();
				}
				return c1;
			}
		});
		
		if(titleList.size() == 0) answer = "(None)";
		else answer = titleList.get(0).getTitle();
		
		return answer;
	}
	
	private String melodyReplace(String m) {
		String[] sound = {"C#", "C", "D#", "D", "E", "F#", "F", "G#", "G", "A#", "A", "B"};
		
		char ch = 97;
		for (int i = 0; i < sound.length; i++) {
			m = m.replaceAll(sound[i], String.valueOf(Character.toChars(ch+i)));
		}
		return m;
	}
}

class MusicInfo{
	private int no;
	private String startTime, endTime;
	private String title, musicSheet;
	private int playTime, mLen;
	private String playMelody;
	
	public MusicInfo(String[] musicInfo, int no, int mLen) {
		this.startTime = musicInfo[0];
		this.endTime = musicInfo[1];
		this.title = musicInfo[2];
		this.musicSheet = musicInfo[3];
		this.no = no;
		this.mLen = mLen;
		
		this.playTime = makeDiffTime();
		this.playMelody = makePlayMelody();
	}
	
	private int makeDiffTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date d1 = null, d2 = null;
		
		try {
			d1 = format.parse(this.startTime);
			d2 = format.parse(this.endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return (int) (d2.getTime() - d1.getTime()) / (60*1000);
	}
	
	private String makePlayMelody() {
		int musicSheetTime = this.musicSheet.length();
		int quot = this.playTime / musicSheetTime ;
		int rem = this.playTime % musicSheetTime ;
		
		StringBuilder sb = new StringBuilder();

		while(quot > 0) {
			sb.append(this.musicSheet);
			quot--;
			if(sb.length() > (this.mLen*2)) break;
		}
		 
		if(quot == 0)		sb.append(this.musicSheet.substring(0, rem));
		 
		return sb.toString();
	}

	public String getTitle() {	return title; 	}
	
	public String getPlayMelody() {	return playMelody; 	}
	
	public int getPlayTime() {	return playTime; 	}
	
	public int getNo() {	return no;	}
	
	@Override
	public String toString() {
		return "[no=" + no +", title=" + title + ", playTime=" + playTime + ", playMelody=" + playMelody + "]";
	}
	
}