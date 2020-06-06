// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Matt Csukker
// RESOURCES: No outside resources were used for my code.

package reports;

/**
 * An Exception to be thrown if it is attempted to write a report that has not been processed. The "serialVersionUID"
 * warning can be suppressed.
 * @author mattcsukker
 */
@SuppressWarnings("serial") 
public class DataNotProcessedException extends java.lang.RuntimeException
{
	/**
	 * Sets the message of the Exception.
	 */
	public DataNotProcessedException()
	{
		super("Data not processed, cannot write report");
	}
}
