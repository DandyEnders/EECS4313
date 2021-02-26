package eecs4313a2b;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import net.sf.borg.common.DateUtil;

public class date_util_minuteStringTest {          //minuteString method in DateUtil

	/* Testing Series of inputs; for equivalence class testing 
	 * BlackBox Testing
	 */ 
	
	@Test
	public void test() {
		/*Test 1-5: Start off by testing a number of minutes that will yield an even amount of hours with no minutes
		 * 1 hour: 60 mins, 2 hours: 120 mins, 3 hours: 180 mins, 4 hours: 240 mins, 5 hours: 300 mins 
		 */
		
		//60 mins
		assertEquals("1 Hour", DateUtil.minuteString(60));
		//120 mins 
		assertEquals("2 Hours", DateUtil.minuteString(120));
		//180 mins 
		assertEquals("3 Hours", DateUtil.minuteString(180));
		//240 mins
		assertEquals("4 Hours", DateUtil.minuteString(240));
		//300 mins  
		assertEquals("5 Hours", DateUtil.minuteString(300));
	
		/*Test 6-10: Next test a number of minutes 
		 * 0 minutes: 0 mins, 1 minutes: 1 mins, 10 minutes: 10 mins, 25 minutes: 25 mins, 59 minutes: 59 mins 
		 */
		
		//60 mins
		assertEquals("0 minutes", DateUtil.minuteString(0));
		//120 mins 
		assertEquals("1 minute", DateUtil.minuteString(1));
		//180 mins 
		assertEquals("10 minutes", DateUtil.minuteString(10));
		//240 mins
		assertEquals("25 minutes", DateUtil.minuteString(25));
		//300 mins  
		assertEquals("59 minutes", DateUtil.minuteString(50));
		
		/*Test 10-15: Finally taking the input of some arbitrary minutes the validate output string
		 * 1 hour and 10 minutes: 70 mins, 2 hours and 1 minute: 121 mins, 3 hours and 20 minutes: 200 mins, 4 hours and 15 minutes: 255 mins, 
		 * 5 hours and 59 minutes: 359 mins 
		 */
		
		//70 mins
		assertEquals("1 hour and 10 minutes", DateUtil.minuteString(70));
		//121 mins 
		assertEquals("2 hours and 1 minute", DateUtil.minuteString(121));
		//200 mins 
		assertEquals(" 3 hours and 20 minutes", DateUtil.minuteString(200));
		//255 mins
		assertEquals("4 hours and 15 minutes", DateUtil.minuteString(255));
		//359 mins  
		assertEquals("5 hours and 59 minute", DateUtil.minuteString(359));
		
	}

}
