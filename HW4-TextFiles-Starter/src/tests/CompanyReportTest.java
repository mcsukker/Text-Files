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
import reports.YearReport;

/**
 * Tests the CompanyReport class.
 * @author mattcsukker
 */
public class CompanyReportTest 
{
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
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		String expected = "Fortune 500 Report for Nike ranked 0 times\n" + 
				"Revenue\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Profit\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Rank\n" + 
				"Min: null Max: null Avg: nul StD: nul";
		
		assertEquals("Problem in CompanyReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, c.toString());   
	}

	/**
	 * Tests the constructor.
	 */
	@Test
	public void constructorTest()
	{ 
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		c.getCompany();
		assertEquals("Nike", c.getCompany());
	}
	
	/**
	 * Tests the processReport method while true.
	 */
	@Test
	public void processReportTestTrue()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		c.processReport();
		assertTrue(c.processReport()); 
	}
	
	/**
	 * Tests the processReport method when file is not found.
	 */
	@Test
	public void processReportTestFNFE()
	{
		CompanyReport c = new CompanyReport(new File("fakefileyo.asdf"), "Nike");
		c.processReport();
		assertFalse(c.processReport()); 
	}
	
	/**
	 * Tests the writeReport method when true.
	 */
	@Test
	public void writeReportTestTrue()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		File file = new File("fortune500.csv");
		c.writeReport(file);
		assertTrue(c.writeReport(file)); 
	}
	
	/**
	 * Tests the writeReport method with FileNotFoundException.
	 */
	@Test
	public void writeReportFNFE()
	{
		CompanyReport c = new CompanyReport(new File("fakefile.asdf"), "Nike");
		File file = new File("fakefile.asdf");
		c.processReport();
		c.writeReport(file);
		assertTrue(c.writeReport(file));  
	}
	
	/**
	 * Tests the writeReport method with data not processed exception.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
	 */
	@Test
	public void writeReportTestDNPE() throws DataNotProcessedException
	{
		CompanyReport c = new CompanyReport(new File("fakefileyo.asdf"), "Nike");
		File file = new File("fauxfile.asdf");
		thrown.expect(DataNotProcessedException.class);
		c.writeReport(file);
		assertTrue(c.writeReport(file));
	}
}
