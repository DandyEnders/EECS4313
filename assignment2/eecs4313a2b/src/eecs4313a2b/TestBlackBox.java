package eecs4313a2b;

import static org.junit.Assert.*;

import org.junit.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBlackBox {

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
	public void testIsAfterA1() {
		assertTrue(DateUtil.isAfter(dateAfter, dateBefore));    // C1: Case1, d1 comes after d2
	}
	
	@Test
	public void testIsAfterA2() {
		assertFalse(DateUtil.isAfter(dateBefore, dateAfter));   // C2: Case2, d2 comes after d1
	}
	
	@Test
	public void testIsAfterA3() {
		assertFalse(DateUtil.isAfter(dateBefore, dateBefore2)); // C3: Case3, two dates are equal
	}

}
