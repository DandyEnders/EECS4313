package eecs4313a3t1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.sf.borg.common.Resource;

public class TaskModel {

	/**
	 * determine the number fo days between two dates
	 * 
	 * @param start
	 *            the first date
	 * @param dd
	 *            the later date
	 * 
	 * @return the int
	 */
	public static int daysBetween(Date start, Date dd) {

		if (dd == null)
			return 0;
		Calendar startcal = new GregorianCalendar();
		Calendar dcal = new GregorianCalendar();
		dcal.setTime(dd);
		startcal.setTime(start);

		// find days left
		int days = 0;
		if (dcal.get(Calendar.YEAR) == startcal.get(Calendar.YEAR)) {
			days = dcal.get(Calendar.DAY_OF_YEAR)
					- startcal.get(Calendar.DAY_OF_YEAR);
		} else {
			days = Long.valueOf((dd.getTime() - startcal.getTime().getTime())
					/ (1000 * 60 * 60 * 24)).intValue();
		}

		// if due date is past, set days left to 0
		// negative days are silly
		if (days < 0)
			days = 0;
		return days;
	}
	
	/**
	 * Checks if one date falls on a later calendar day than another.
	 * 
	 * @param d1
	 *            the first date
	 * @param d2
	 *            the second date
	 * 
	 * @return true, if is after
	 */
	public static boolean isAfter(Date d1, Date d2) {

		GregorianCalendar tcal = new GregorianCalendar();
		tcal.setTime(d1);
		tcal.set(Calendar.HOUR_OF_DAY, 0);
		tcal.set(Calendar.MINUTE, 0);
		tcal.set(Calendar.SECOND, 0);
		GregorianCalendar dcal = new GregorianCalendar();
		dcal.setTime(d2);
		dcal.set(Calendar.HOUR_OF_DAY, 0);
		dcal.set(Calendar.MINUTE, 10);
		dcal.set(Calendar.SECOND, 0);

		if (tcal.getTime().after(dcal.getTime())) {
			return true;
		}

		return false;
	}
	
	/**
	 * generate a human readable string for a particular number of minutes
	 * 
	 * @param mins - the number of minutes
	 * 
	 * @return the string
	 */
	public static String minuteString(int mins) {
		
		int hours = mins / 60;
		int minsPast = mins % 60;
		
		String minutesString;
		String hoursString;
		
		if (hours > 1) {
			hoursString = hours + " " + Resource.getResourceString("Hours");
		} else if (hours > 0) {
			hoursString = hours + " " + Resource.getResourceString("Hour");
		} else {
			hoursString = "";
		}

		if (minsPast > 1) {
			minutesString = minsPast + " " + Resource.getResourceString("Minutes");
		} else if (minsPast > 0) {
			minutesString = minsPast + " " + Resource.getResourceString("Minute");
		} else if (hours >= 1) {
			minutesString = "";
		} else {
			minutesString = minsPast + " " + Resource.getResourceString("Minutes");
		}

		// space between hours and minutes
		if (!hoursString.equals("") && !minutesString.equals(""))
			minutesString = " " + minutesString;

		return hoursString + minutesString;
	}
	
}
