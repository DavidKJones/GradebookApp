package gradebookapp;

import java.io.IOException;

/**
 * invalid score exception class
 * @author david
 */
@SuppressWarnings("serial")
public class InvalidScoreException extends IOException 
{
	public InvalidScoreException()
	{
		super();
	}
	
	public InvalidScoreException(String str)
	{
		super(str);
	}
}
