import java.io.IOException;

/**
 * Exception class that is thrown when a date is invalid.
 * @author david
 */
@SuppressWarnings("serial")
public class InvalidDateException extends IOException 
{
	/**
	 * 
	 */
	public InvalidDateException() 
	{
		super();
	}

	/**
	 * 
	 * @param arg0
	 */
	public InvalidDateException(String arg0) 
	{
		super(arg0);
	}

}
