package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Util {
	private static Scanner scanner = new Scanner(System.in);
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd"); 
	
	public static String nextLine(String Input) {
		System.out.println(Input);
		return scanner.nextLine();
	}
	
	public static int nextInt(String Input) {
		return Integer.parseInt(nextLine(Input));
	}
	
	public static int getKorCnt(String string) { // 가 ~ 힣
		int cnt = 0;
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) >= '가' && string.charAt(i) <= '힣') {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static String convert(String word, int size) {
		String fomatter = String.format("%%%ds", size - getKorCnt(word));
		return String.format(fomatter, word);
	}
	public static String convert(int word, int size) {
		return convert(word+"", size);
	}
	
	public static long str2Epoch(String str) {
//		str 2022-02-13 >> long
		long r = 0;
		try {
			r = SDF.parse(str).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public static String epoch2Str(long epoch) {
		return SDF.format(epoch);
	}
	
	public static long floorEpoch(long time) {
		return str2Epoch(epoch2Str(time));
	}
	
	public static void main(String[] args) {
		// 시간정보 >> long
		// 1970-01-01 00:00:00          >> 0
		// 1970-01-01 00:00:01          >> 1000
//		1970-01-01 00:01:00             >> 60000
		System.out.println(System.currentTimeMillis());
		System.out.println(epoch2Str(System.currentTimeMillis()));
		System.out.println(floorEpoch(System.currentTimeMillis()));
	}
}
