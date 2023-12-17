/**
 * Class: B.Sc. in Computing
 * Instructor: Maria Boyle
 * Description: Tester for the Date class
 * Date: dd/mm/yyyy
 * @author Maria Boyle
 * @version 1.0
**/
package ie.lyit.testers;

import ie.lyit.flight.Date;
import java.util.Scanner;

public class DateTester{
	public static void main(String[] args) {
		Date date1 = new Date();
        System.out.println(date1);      

	    date1.setDay(12);
		date1.setMonth(12);
		date1.setYear(1945);
		
		System.out.println(date1);
      
		Date date2 = new Date(28, 12, 1982);
        System.out.println(date2);
      
		if(date1.equals(date2))
			System.out.println("The dates are the same");
		else
			System.out.println("The dates are not the same");
		
		Date dateA = new Date();
		int setDayTo=32, setMonthTo=13, setYearTo=-2009;
		boolean validateEntry=false;
		Scanner keyboard = new Scanner(System.in);
		
		
		validateEntry=false;
		setDayTo=1;	setMonthTo=13;	setYearTo=2023;
		do {
			try {
				Date dateB = new Date(setDayTo,setMonthTo,setYearTo);
			}
			catch(IllegalArgumentException iEA){
				System.out.println("Incorrect day, month or year.");
				
				System.out.print("Enter day [1-31]:");
				setDayTo = keyboard.nextInt();
				System.out.print("Enter month [1-12]:");
				setMonthTo = keyboard.nextInt();
				System.out.print("Enter Year [above 1900]:");
				setYearTo = keyboard.nextInt();				
			}
		}while(!validateEntry);
   }
}

