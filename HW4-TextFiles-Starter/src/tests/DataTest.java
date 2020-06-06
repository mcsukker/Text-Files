// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Matt Csukker
// RESOURCES: No outside resources were used for my code.

package tests;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import analytics.Data;

/**
 * Test class for Data.java class.
 * @author mattcsukker
 */
public class DataTest
{
	/**
	 * I forgot what this does but it makes stuff work.
	 */
	public static final double DOUBLE_TOLERANCE = .001;
	
	/**
	 * Tests the minimum method while all numbers are valid.
	 */
	@Test
	public void testMinimumValid()
	{
		Data t = new Data();
		Integer [] test = new Integer[5];
		test[0] = 15;
		test[1] = 5;
		test[2] = 123;
		test[3] = 46;
		test[4] = 38; 
		assertEquals(test[1], Data.minimum(test));
	}
	
	/**
	 * Tests the minimum method while a number is null.
	 */
	@Test
	public void testMinimumNull()
	{
		Data t = new Data();
		Integer [] test = new Integer[7];
		test[0] = 15;
		test[1] = 5;
		test[2] = 123;
		test[3] = 46;
		test[4] = null;
		test[5] = 1;
		test[6] = 17;
		assertEquals(test[1], Data.minimum(test));
	}
	
	/**
	 * Tests the maximum method while all numbers are valid.
	 */
	@Test
	public void testMaximumValid()
	{
		Data t = new Data();
		Integer [] test = new Integer[5];
		test[0] = 15;
		test[1] = 5;
		test[2] = 123;
		test[3] = 46;
		test[4] = 38;
		assertEquals(test[2], Data.maximum(test));
	}
	
	/**
	 * Tests the maximum method when a number is null.
	 */
	@Test
	public void testMaximumNull()
	{
		Data t = new Data();
		Integer [] test = new Integer[7];
		test[0] = 15;
		test[1] = 5;
		test[2] = 123;
		test[3] = null;
		test[4] = 38;
		test[5] = 257;
		test[6] = 199;
		assertEquals(test[2], Data.maximum(test));
	}
	
	/**
	 * Tests the average method when all numbers are valid.
	 */
	@Test
	public void testAverageValid()
	{
		Data t = new Data();
		Integer [] test = new Integer[5];
		test[0] = 55;
		test[1] = 5;
		test[2] = 123;
		test[3] = 12;
		test[4] = 38;
		assertEquals(46.6, Data.average(test), DOUBLE_TOLERANCE); 
	}
	
	/**
	 * Tests the average method when there's a null value.
	 */
	@Test
	public void testAverageNull()
	{
		Data t = new Data();
		Integer [] test = new Integer[7];
		test[0] = 55;
		test[1] = 5;
		test[2] = 123;
		test[3] = 12;
		test[4] = 38;
		test[5] = null; 
		test[6] = 15;
		assertEquals(46.6, Data.average(test), DOUBLE_TOLERANCE); 
	}
	
	/**
	 * Tests the standard deviation method when valid.
	 */
	@Test
	public void testStandardDeviationValid()
	{
		Data t = new Data();
		Integer [] test = new Integer[5];
		test[0] = 600;
		test[1] = 470;
		test[2] = 170;
		test[3] = 430;
		test[4] = 300;
		assertEquals(147.323, Data.standardDeviation(test), DOUBLE_TOLERANCE); 
	}
	
	/**
	 * Tests the standard deviation method when a value is null.
	 */
	@Test
	public void testStandardDeviationNull()
	{
		Data t = new Data();
		Integer [] test = new Integer[8];
		test[0] = 600;
		test[1] = 470;
		test[2] = 170;
		test[3] = 430;
		test[4] = 300; 
		test[5] = null;
		test[6] = 200; 
		test[7] = 150;
		assertEquals(147.323, Data.standardDeviation(test), DOUBLE_TOLERANCE); 
	}
}
