package gradebookapp;

import javax.swing.JOptionPane;

/**
 * <h1>Date</h1>
 * Class to instantiate date object
 * @author david
 *
 */
public class Date
{
	//fields
	private int month;
	private int year;
	private int day;
	private String dateString;
	
	//default constructor
	public Date() 
	{
		dateString = "No Date";
		setDate(1,1,1);
	}
	
	/**
	 * Set the date.
	 * @param month
	 * @param day
	 * @param year
	 * @throws InvalidDateException
	 */
	public void setDate( int month, int day, int year )
	{
		try
		{
			//check to see if the year is not negative
			if(year < 0)
				throw new InvalidDateException ("Invalid year");
			
			//check to see if it is a leap year
			boolean isLeapYear = year % 4 == 0;
			
			//check to see if the month passed is within 1-12
			if(month < 1 || month > 12)
				throw new InvalidDateException( month  + " is an invalid month.");
			
			int maxDayInMonth = 0;
			
			//set the number of the last day based on the month
			if(month == 1 || month == 3 || month == 5 || month == 7 
					|| month == 8 || month == 10 || month == 12)
				maxDayInMonth = 31;
			
			else if(month == 4 || month == 6 || month == 9 || month == 11)
				maxDayInMonth = 30;
			
			else if(month == 2)
				if(isLeapYear)
					maxDayInMonth = 29;
				else
					maxDayInMonth = 28;
			
			//check to see if the day exists
			if(day < 1 || day > maxDayInMonth)
				throw new InvalidDateException(day + " doesn't exist in the month.");
			
			this.year = year;
			this.day = day;
			this.month = month;
			dateString = String.format("%d/%d/%d", month, day, year); 
		}
		catch( InvalidDateException ex )
		{
			System.out.println(ex);
		}
	}
	
	@Override
	public String toString()
	{
		return dateString;
	}
}