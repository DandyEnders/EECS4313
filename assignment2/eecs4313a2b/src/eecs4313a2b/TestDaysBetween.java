package eecs4313a2b;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import net.sf.borg.model.TaskModel;

@RunWith(Parameterized.class)
public class TestDaysBetween {
	
	private Date startDate;
	private Date endDate;
	
	public TestDaysBetween(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * Inputs for parameterized tests.
	 * @return Inputs for parameterized tests.
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> datePair() {
		return Arrays.asList(new Object[][] {
			{new Date(Long.MIN_VALUE), new Date(Long.MIN_VALUE)},
			{new Date(Long.MIN_VALUE), new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24)},
			{new Date(Long.MIN_VALUE), new Date(0)},
			{new Date(Long.MIN_VALUE), new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24)},
			{new Date(Long.MIN_VALUE), new Date(Long.MAX_VALUE)},
			{new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24), new Date(Long.MIN_VALUE)},
			{new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24), new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24)},
			{new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24), new Date(0)},
			{new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24), new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24)},
			{new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24), new Date(Long.MAX_VALUE)},
			{new Date(0), new Date(Long.MIN_VALUE)},
			{new Date(0), new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24)},
			{new Date(0), new Date(0)},
			{new Date(0), new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24)},
			{new Date(0), new Date(Long.MAX_VALUE)},
			{new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24), new Date(Long.MIN_VALUE)},
			{new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24), new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24)},
			{new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24), new Date(0)},
			{new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24), new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24)},
			{new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24), new Date(Long.MAX_VALUE)},
			{new Date(Long.MAX_VALUE), new Date(Long.MIN_VALUE)},
			{new Date(Long.MAX_VALUE), new Date(Long.MIN_VALUE + 1000 * 60 * 60 * 24)},
			{new Date(Long.MAX_VALUE), new Date(0)},
			{new Date(Long.MAX_VALUE), new Date(Long.MAX_VALUE - 1000 * 60 * 60 * 24)},
			{new Date(Long.MAX_VALUE), new Date(Long.MAX_VALUE)},
		});
	}

	@Test
	/**
	 * Boundary testings for daysBetween Method
	 */
	public void daysBetweenTest() {
		LocalDate startLocalDate = LocalDate.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
		LocalDate endLocalDate = LocalDate.ofInstant(endDate.toInstant(), ZoneId.systemDefault());
		double actualAnswer = TaskModel.daysBetween(startDate, endDate);
		double expectedAnswer = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
		
		//While not in the JavaDocs, this behaviour is commented in the code.
		if (expectedAnswer < 0) {
			expectedAnswer = 0;
		}
		
		assertEquals("Days between " + startLocalDate.toString() + " and "
				+ endLocalDate.toString() + ":", expectedAnswer, actualAnswer, 0.000001);
	}

}