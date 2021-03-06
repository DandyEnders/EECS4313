package eecs4313a2w;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	
}
