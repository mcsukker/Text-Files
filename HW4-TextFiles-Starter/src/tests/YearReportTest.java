// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Matt Csukker
// RESOURCES: No outside resources were used for my code.

package tests;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import reports.CompanyReport;
import reports.DataNotProcessedException;
import reports.YearNotFoundException;
import reports.YearReport;

/**
 * Tests the YearReport class.
 * @author mattcsukker
 */
public class YearReportTest {
	
	/**
	 * Used for testing the DataNotProcessedException.
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Tests the toString method.
	 */
	@Test
	public void unprocessedToStringTest()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2020);
		String expected = "Fortune 500 Report for 2020\n" + 
				"Revenue\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Profit\n" + 
				"Min: nul Max: nul Avg: nul StD: nul";
		
		assertEquals("Problem in YearReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, y.toString()); 
	}
 
	/**
	 * Tests the constructor.
	 */
	@Test
	public void yearReportTestConstructor()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2020);
		y.getYear();
	}
	
	/**
	 * Tests the processReport method while true.
	 */
	@Test
	public void yearReportTestProcessReportTrue()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2012);
		y.processReport();
		assertTrue(y.processReport());
	}
	
	/**
	 * Tests the processReport method with FileNotFoundException.
	 */
	@Test
	public void yearReportTestProcessReportFNFE()
	{
		YearReport y = new YearReport(new File("fakefile.asdf"), 2012);
		y.processReport();
		assertTrue(y.processReport()); 
	}
	
	/**
	 * Tests the processReport method with YearNotFoundException.
	 * @throws YearNotFoundException - Thrown if the report's years is not present in the data file.
	 */
	@Test
	public void yearReportTestProcessReportYNFESmall() throws YearNotFoundException
	{
		YearReport y = new YearReport(new File("fortune500.csv"), -1234);
		thrown.expect(YearNotFoundException.class);
		y.processReport();	
	}
	
	/**
	 * Tests the processReport method with YearNotFoundException.
	 * @throws YearNotFoundException - Thrown if the report's years is not present in the data file.
	 */
	@Test
	public void yearReportTestProcessReportYNFEBig() throws YearNotFoundException
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2034);
		thrown.expect(YearNotFoundException.class);
		y.processReport();	
	}
	
	/**
	 * Tests the writeReport method while true.
	 */
	@Test
	public void yearReportTestWriteReportTrue()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2012);
		File file = new File("fortune500.csv");
		y.writeReport(file);
		assertTrue(y.writeReport(file));
	}
	
	/**
	 * Tests the writeReport method with FileNotFoundException.
	 */
	@Test
	public void yearReportTestWriteReportFNFE()
	{
		YearReport y = new YearReport(new File("fakefile.asdf"), 2012);
		File file = new File("fakefile.asdf");
		y.processReport();
		y.writeReport(file);
		assertTrue(y.writeReport(file));  
	}
	
	/**
	 * Tests the writeReport method with data not processed exception.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
	 */
	@Test
	public void yearReportWriteReportTestDNPE() throws DataNotProcessedException
	{
		YearReport y = new YearReport(new File("jhbv"), 2020);
		File file = new File("asfdsaf");
		thrown.expect(DataNotProcessedException.class);
		y.processReport();
		assertFalse(y.processReport());
		y.writeReport(file);
	}
}
