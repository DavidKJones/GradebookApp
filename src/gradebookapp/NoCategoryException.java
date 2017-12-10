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
	/**
	 * 
	 */
	public NoCategoryException()
	{
		super();
	}
	
	/**
	 * 
	 * @param mssg
	 */
	public NoCategoryException(String mssg)
	{
		super(mssg);
	}
}
