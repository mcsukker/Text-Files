// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Matt Csukker
// RESOURCES: No outside resources were used for my code.

package reports;

/**
 * An exception to be thrown if a requested year is not present in the data set. The "serialVersionUID"
 * warning can be suppressed.
 * @author mattcsukker
 */
@SuppressWarnings("serial") 
public class YearNotFoundException extends java.lang.RuntimeException
{
	/**
	 * Sets the message of the Exception.
	 */
	public YearNotFoundException()
	{
		super("Requested year not in file");
	}
}
