// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Matt Csukker
// RESOURCES: No outside resources were used for my code.

package analytics;

/**
 * Set of useful reusable tools for analyzing sets of data.
 * @author mattcsukker
 */
public class Data  
{
	/**
	 * Finds the minimum value in the passed array. NOTE: The array does not need to be completely populated.  
	 * All relevant data to be processed starts at index 0. Unused elements will be null and should not be 
	 * considered in computations. Once the first null is encountered it is assumed remaining elements are 
	 * unused.
	 * @param <E> - Type of data passed. The type must implement the Comparable interface.
	 * @param data - Collection of data to find minimum value of.
	 * @return Minimum value in passed data.
	 */
	public static <E extends java.lang.Comparable<E>> E minimum(E[] data)
	{
		E minimum = data[0]; 
		for (int i = 1; i < data.length; i++) 
		{
			if (data[i] != null) // check for unused elements
			{
				if (minimum.compareTo(data[i]) > 0)
				{
					minimum = data[i];
				} 
			}
			else
			{
				break;
			}
		}
		return minimum;
	}
	
	/**
	 * Finds the maximum value in the passed array. NOTE: The array does not need to be completely populated.  
	 * All relevant data to be processed starts at index 0. Unused elements will be null and should not be 
	 * considered in computations. Once the first null is encountered it is assumed remaining elements are 
	 * unused.
	 * @param <E> - Type of data passed. The type must implement the Comparable interface.
	 * @param data - Collection of data to find maximum value of. 
	 * @return Maximum value in passed data.
	 */
	public static <E extends java.lang.Comparable<E>> E maximum(E[] data)
	{
		E max = data[0];
		for (int i = 1; i < data.length; i++)
		{
			if (data[i] != null) // check for unused elements
			{
				if (max.compareTo(data[i]) < 0)
				{
					max = data[i];
				}
			}
			else
			{
				break;
			}
		}
		return max;
	}
	
	/**
	 * Finds the average of values in the passed array. NOTE: The array does not need to be completely populated.  
	 * All relevant data to be processed starts at index 0. Unused elements will be null and should not be 
	 * considered in computations. Once the first null is encountered it is assumed remaining elements are 
	 * unused.
	 * @param <N> - Type of data passed. The type must extend the Number class. See the assignment supplemental 
	 * for useful information on the Number class.
	 * @param data - Collection of data to find average of.
	 * @return Average of passed data. Regardless of type passed will always return a Double. This means if no 
	 * results are in data it will return Double's "Divide by 0" value, NaN, which it should do automatically.
	 */
	public static <N extends java.lang.Number> java.lang.Double average(N[] data)
	{
		Double sum = 0.0;
		Double avg = 0.0;
		Double counter = 0.0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] != null) 
			{
				counter++;
				sum += data[i].doubleValue();
				avg = sum / counter;
			}
			else 
			{ 
				break;
			}
		}
		return avg;
	}
	
	/**
	 * Finds the population standard deviation of values in the passed array. NOTE: The array does not need 
	 * to be completely populated. All relevant data to be processed starts at index 0. Unused elements will
	 * be null and should not be considered in computations. Once the first null is encountered it is assumed 
	 * remaining elements are unused.
	 * @param <N> - Type of data passed. The type must extend the Number class. See the assignment supplemental 
	 * for useful information on the Number class.
	 * @param data - Collection of data to find standard deviation of.
	 * @return Population Standard deviation of passed data. Regardless of type passed will always return a Double. 
	 * This means if no results are in data it will return Double's "Divide by 0" value, NaN, which it should 
	 * do automatically.
	 */
	public static <N extends java.lang.Number> java.lang.Double standardDeviation(N[] data)
	{
		Double sum = 0.0;
		Double mean = 0.0;
		Double newSum = 0.0; 
		Double counter = 0.0;
		Double newMeanSquared = 0.0;
		Double finalAns = 0.0;
		for (int i = 0; i < data.length; i++)  
		{
			if (data[i] != null)
			{
				sum += data[i].doubleValue(); 
				counter++;
			}
			else
			{
				break;
			}
		}
		mean = sum / counter; 
		for (int j = 0; j < data.length; j++) 
		{
			if (data[j] != null)
			{
				newSum = newSum + ((data[j].doubleValue() - mean) * (data[j].doubleValue() - mean));
			}
			else
			{
				break;
			}
		}
		newMeanSquared = newSum / counter; 
		finalAns = Math.sqrt(newMeanSquared); 
		return finalAns; 	 
	}
}
