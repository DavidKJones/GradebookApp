package gradebookapp;

import java.io.IOException;

/**
 * Exception class that is thrown when a date is invalid.
 * @author david
 */
@SuppressWarnings("serial")
public class InvalidDateException extends IOException 
{
	/**
	 * default constructor 
	 */
	public InvalidDateException() 
	{
		super();
	}

	/**
	 * constructor
	 * @param arg0
	 */
	public InvalidDateException(String arg0) 
	{
		super(arg0);
	}

}