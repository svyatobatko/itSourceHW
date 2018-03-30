package itSourceHW.hw9;

import java.util.Scanner;

public class ClockDegrees {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите время (если в конце не указан am/pm, то берется формат ремени 24):");
		String varTime = sc.nextLine();
		String[] posArrow = varTime.split(":");
		String[] posArrowMin = posArrow[1].split(" ");
		int hours = Integer.parseInt(posArrow[0]);
		int minutes = Integer.parseInt(posArrowMin[0]);
		int formatClock = getFormatClock (varTime);
		int degrees = getDegreeClockArrow(formatClock, hours, minutes);
		System.out.println("Градусы между стрелками: " + degrees);
	}
	
	static int getDegreeClockArrow(int format, int hour, int minute) {
		int degree = 0;
		int hourPosition = 360 / format * hour;
		int minutePosition = 360 / 60 * minute;
		if (hourPosition > minutePosition) {
			degree = 360 - hourPosition + minutePosition;
		} else {
			degree = minutePosition - hourPosition;
		}
		
//		System.out.println(hourPosition);
//		System.out.println(minutePosition);
		
		return degree;
	}
	
	static int getFormatClock (String time) {
		String timeUpper = time.toUpperCase();
//		System.out.println(timeUpper.substring(timeUpper.length()-1).equals("M") + " " + timeUpper.substring(time.length()-1));
		if (timeUpper.substring(timeUpper.length()-1).equals("M")) {
			return 12;
		} else {
			return 24;
		}

	}
}
