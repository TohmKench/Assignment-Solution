/**
 * Class: B.Sc. in Computing
 * Instructor: Maria Boyle
 * Description: Tester for the Name class
 * Date: dd/mm/yyyy
 * @author Maria Boyle
 * @version 1.0
**/
package ie.lyit.testers;

import ie.lyit.flight.Name;
import java.util.ArrayList;

public class NameTester {
	public static void main(String[] args) {

		Name personA = new Name();
		System.out.println(personA);			

		
		personA.setTitle("Mr");
		personA.setFirstName("Homer");
		personA.setSurname("Simpson");		
			
	
		System.out.println(personA);

		Name personB = new Name("Mrs", "Lisa", "Simpson");
		

		System.out.println(personB);

		if(personA.equals(personB))
			System.out.println(personA + " is identical to " + personB);
		else
			System.out.println(personA + " is not the same as " + personB);

		if(personA.isFemale())	
			System.out.println(personA + " is a female");			
		else
			System.out.println(personA + " is a male");					

		if(personB.isFemale())
			System.out.println(personB + " is a female.");			
		else
			System.out.println(personB + " is a male");

	    ArrayList<Name> names = new ArrayList<Name>();
	    names.add(new Name("Mr", "Bart", "Simpson"));
	    names.add(personA);
	    names.add(personB);

	    for(Name tempName:names )
	       System.out.println(tempName); 
	}
}
