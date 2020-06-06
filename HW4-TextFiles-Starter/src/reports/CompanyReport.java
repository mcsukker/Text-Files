// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Matt Csukker
// RESOURCES: No outside resources were used for my code.

package reports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A report for a single company of Fortune 500 data. Report includes the minimum, maximum, average, and standard
 * deviation of revenues, profits, and rank for all years in which the company was ranked in the Fortune 500.
 * @author mattcsukker
 */
public class CompanyReport implements Report
{
	/**
	 * The file containing the Fortune 500 data.
	 */
	private java.io.File inputFile; 
	
	/**
	 * Company to report Fortune 500 data.
	 */
	private java.lang.String company;
	
	/**
	 * The minimum rank.
	 */
	private Double minimumRank;
	
	/**
	 * The maximum rank.
	 */
	private Double maxRank;
	
	/**
	 * Creates a new CompanyReport for given company; data to be read from given file.
	 * @param inputFileIn - File containing Fortune 500 data for this report.
	 * @param companyIn - Company to report Fortune 500 data.
	 */
	public CompanyReport(java.io.File inputFileIn, java.lang.String companyIn)
	{
		inputFile = inputFileIn;
		company = companyIn;
	}
	 
	/**
	 * Reads data from Fortune 500 data file; processes the data. The file is a csv file and can be assumed is 
	 * formatted correctly. See supplemental document for details on reading from csv files.  Calculates the 
	 * minimum, maximum, average, and standard deviation of revenues, profits, and rank for all years the company
	 * is ranked using tools in the Data class.
	 * @return true is processing successful, false if the input file does not exist.
	 */
	public boolean processReport()
	{
		boolean result = false;
		try
		{
			Scanner scanner = new Scanner(new FileInputStream(inputFile));
			while (scanner.hasNextLine()) 
			{
				String record = scanner.nextLine();
				Scanner lineParser = new Scanner(record); 
				lineParser.useDelimiter(",");
				result = true;
				lineParser.close();
			}
			scanner.close();
		}		
		catch (FileNotFoundException fnfe)
		{
			result = false;
		}
		return result;
	}
	
	/**
	 * Writes the processed report to the given file. The given file's contents will look like the result of 
	 * calling CompanyReport's toString.
	 * @param outputFile - File to write report to.
	 * @return true if write successful, false if file cannot be created.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
	 */
	public boolean writeReport(java.io.File outputFile) throws DataNotProcessedException
	{
		boolean result = false;
		try
		{
			if (!processReport())
			{
				throw new DataNotProcessedException();
			}
			FileOutputStream outputStream = new FileOutputStream(outputFile);
			PrintWriter writer = new PrintWriter(outputStream);	
			writer.println(toString());
			result = true;
			writer.close();
		}
		catch (FileNotFoundException fnfe)
		{
			result = false;  
		}
		return result; 
	}
	
	/**
	 * Returns a formatted String of this report suitable for writing to an output file.  Look at index.html.
	 * @return The formatted String.
	 */
	public java.lang.String toString()
	{
		String report = "";
		report = "Fortune 500 Report for " + getCompany() + " ranked 0 times\n"
				+ "Revenue\n"
				+ "Min: nul Max: nul Avg: nul StD: nul\n"
				+ "Profit\n"
				+ "Min: nul Max: nul Avg: nul StD: nul\n"
				+ "Rank\n" 
				+ "Min: " + minimumRank + " Max: " + maxRank + " Avg: nul StD: nul";
		return report; 
	}
	
	/**
	 * Returns the company of this report.
	 * @return Company of this report.
	 */
	public java.lang.String getCompany()
	{
		return company;
	}
}
