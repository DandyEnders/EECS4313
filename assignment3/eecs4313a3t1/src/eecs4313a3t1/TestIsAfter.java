package eecs4313a3t1;

import static org.junit.Assert.*;

import org.junit.*;

//import net.sf.borg.common.DateUtil;
import java.util.*;
import java.text.SimpleDateFormat;

public class TestIsAfter {

	private Date dateAfter, dateBefore, dateBefore2, dateAndTime;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private SimpleDateFormat sdfTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Before
	public void setUp() throws Exception {
		String dateString1 = "13-12-2020";
		String dateString2 = "12-01-2020";
		dateAfter = sdf.parse(dateString1);
		dateBefore = sdf.parse(dateString2);
		dateBefore2 = sdf.parse(dateString2);
		
		String dateString3 = dateString1 + " 12:12:12";
		dateAndTime = sdfTime.parse(dateString3);
	}

	@Test
	public void testIsAfterC1() { // C1: Case1, d1 comes after d2
		assertTrue(TaskModel.isAfter(dateAfter, dateBefore));
	}

	@Test
	public void testIsAfterC2() { // C2: Case2, d2 comes after d1
		assertFalse(TaskModel.isAfter(dateBefore, dateAfter));
	}

	@Test
	public void testIsAfterC3() { // C3: Case3, two dates are equal
		assertFalse(TaskModel.isAfter(dateBefore, dateBefore2)); 
	}
	
	@Test
	public void testIsAfterTime() {
		assertFalse(TaskModel.isAfter(dateAndTime, dateAndTime));
	}
	
}
