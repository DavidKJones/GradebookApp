package gradebookapp;

import java.io.IOException;

/**
 * 
 * @author david
 *
 */
@SuppressWarnings("serial")
public class NoCategoryException extends IOException 
{
	/**default constructor
	 * 
	 */
	public NoCategoryException()
	{
		super();
	}
	
	/**constructor with one parameter
	 * 
	 * @param mssg string
	 */
	public NoCategoryException(String mssg)
	{
		super(mssg);
	}
}
