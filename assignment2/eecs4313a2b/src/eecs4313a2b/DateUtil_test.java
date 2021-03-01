package eecs4313a2b;
import static org.junit.Assert.*;

import org.junit.Test;

import com.toedter.calendar.DateUtil;

public class DateUtil_test {

	/*
	 * partitions: 
	 * 
	 * 10 cases: negative int (-1), 0, 1, [2,59], 60, 61, [62, 119], 60*n where n
	 * >1, 60*n + 1 where n >=1, 60*n + [2,59] n >= 1 NOTE: for testing purposes,
	 * arbitrary numbers where selected
	 */
	@Test
	public void testNEG() { // Negative integer (-1)
		// should fail because neg ints are not handled in source code
		assertEquals("-1 Minute", DateUtil.minuteString(-1));       //should otuput -1
		
		assertEquals("-20 Minutes", DateUtil.minuteString(-20));   //should output -20
		
	}

	@Test
	public void testZERO() { // 0
		assertEquals("0 Minutes", DateUtil.minuteString(0));
	}

	@Test
	public void testONE() { // 1 min
		assertEquals("1 Minute", DateUtil.minuteString(1));
	}

	@Test
	public void test2to59() { // [2,59] mins //arbitrary num in range (i.e. 15)
		assertEquals("15 Minutes", DateUtil.minuteString(15));
		
		assertEquals("30 Minutes", DateUtil.minuteString(30));
		
		assertEquals("59 Minutes", DateUtil.minuteString(59));
	}

	@Test
	public void test60() { // 60 mins
		assertEquals("1 Hour", DateUtil.minuteString(60));
	}

	@Test
	public void test61() { // 61 mins
		assertEquals("1 Hour 1 Minute", DateUtil.minuteString(60));
	}

	@Test
	public void test62to119() { // [62,119] mins //arbitrary num in range (i.e. 100)
		
		assertEquals("1 Hour and 15 Minutes", DateUtil.minuteString(75));
		
		assertEquals("1 Hour 40 Minutes", DateUtil.minuteString(100));
	}

	/* n will be arbitrarily 5 for the next 3 cases */
	@Test
	public void test60timesn1() { // 60*n where n >1
		assertEquals("5 Hours", DateUtil.minuteString(300));
	}

	@Test
	public void test60timesn2() { // 60*n + 1 where n >=1
	assertEquals("3 Hours 1 Minute", DateUtil.minuteString(301));
	}

	@Test
	public void test60timesn3() { // 60*n + [2,59] n >= 1 //arbitrary num in range (i.e. 59)
	assertEquals("5 Hours 10 Minutes", DateUtil.minuteString(310));
	
	assertEquals("5 Hours 59 Minutes", DateUtil.minuteString(359));
	}

}
