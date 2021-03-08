package eecs4313a2b;

import static org.junit.Assert.*;

import org.junit.*;

import net.sf.borg.common.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestIsAfter {

	private Date dateAfter, dateBefore, dateBefore2;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	@Before
	public void setUp() throws Exception {
		String dateString1 = "13-12-2020";
		String dateString2 = "12-01-2020";
		dateAfter = sdf.parse(dateString1);
		dateBefore = sdf.parse(dateString2);
		dateBefore2 = sdf.parse(dateString2);
	}

	@Test
	public void testIsAfterC1() { // C1: Case1, d1 comes after d2
		assertTrue(DateUtil.isAfter(dateAfter, dateBefore));
	}

	@Test
	public void testIsAfterC2() { // C2: Case2, d2 comes after d1
		assertFalse(DateUtil.isAfter(dateBefore, dateAfter));
	}

	@Test
	public void testIsAfterC3() { // C3: Case3, two dates are equal
		assertFalse(DateUtil.isAfter(dateBefore, dateBefore2)); 
	}

}
