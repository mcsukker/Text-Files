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
 * A report for a single year of Fortune 500 data. Report includes the minimum, maximum, average, and standard deviation
 * of revenues and profits for all ranked companies of the report's year.
 * @author mattcsukker
 */
public class YearReport implements Report
{
	/**
	 * The year being reported.
	 */
	private int year;
	
	/**
	 * The file containing the data.
	 */
	private java.io.File inputFile;
	
	/**
	 * Creates a new YearReport for given year; data to be read from given file.
	 * @param inputFileIn - File containing Fortune 500 data for this report.
	 * @param yearIn - Year to report Fortune 500 data.
	 */
	public YearReport(java.io.File inputFileIn, int yearIn)
	{
		inputFile = inputFileIn;
		year = yearIn;	
	}
	
	/** 
	 * Reads data from Fortune 500 data file; processes the data. The file is a csv file and can be assumed is 
	 * formatted correctly. Calculates the minimum, maximum, average, and standard deviation of revenue and profits 
	 * for all ranked companies of the report's year using tools in the Data class.
	 * @return true if processing successful, false if the input file does not exist.
	 * @throws YearNotFoundException - Thrown if the report's years is not present in the data file.
	 */
	public boolean processReport() throws YearNotFoundException
	{
		boolean result = false;
		final int BEG_YEAR = 1955;
		final int END_YEAR = 2020;
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
				if (year < BEG_YEAR || year > END_YEAR)
				{
					throw new YearNotFoundException(); 
				}
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
	 * Writes the processed report to the given file. The given file's contents will look like the result of calling
	 * YearReport's toString.
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
	 * Returns a formatted String of this report suitable for writing to an output file. Look at index.html.
	 * @return The formatted String.
	 */
	public java.lang.String toString()
	{
		String report = "";
		report = "Fortune 500 Report for " + getYear() + "\n" 
				+ "Revenue\n"
				+ "Min: nul Max: nul Avg: nul StD: nul\n"
				+ "Profit\n"
				+ "Min: nul Max: nul Avg: nul StD: nul";
		return report; 
	}
	
	/**
	 * Returns the year of this report.
	 * @return Year of this report.
	 */
	public int getYear()
	{
		return year;
	}
}
