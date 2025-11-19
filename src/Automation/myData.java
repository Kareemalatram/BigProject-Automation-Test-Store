package Automation;

import java.util.Random;

public class myData {
	
	Random rand = new Random();
	
	String [] firstNames = {"Shatha" , "Ahmad" , "Khaled" , "Ali" , "Kareem" , "Leen" , "sana"};
	
	String [] lastNames = {"Aboud" , "Ahmad" , "Ali" , "Kareem" , "Shareef" , "Ammar"};
	
	int randomNumberForTheEmail = rand.nextInt(19845);
	
	String domain = "@gmail.com";
	
	int randomFirstNameIndex = rand.nextInt(firstNames.length);
	int randomLastNameIndex = rand.nextInt(lastNames.length); 

	
	String TheFirstName = firstNames[randomFirstNameIndex];
	String TheLastName = lastNames[randomLastNameIndex];
	
	String TheEmail = TheFirstName + TheLastName +randomNumberForTheEmail + domain;
	
	String telePhone = "96279770023";
	
	String TheFaxNumber = "133810";
	
	String TheAddressOne = "Amman - Jordan";
	
	int theSelectStateIndex = rand.nextInt(1 , 10);
	
	String postalCode  = "19880";
	
	String LOGINNAME =  TheFirstName + TheLastName + randomNumberForTheEmail ;
	
	String Password = "P@$$w0rd";
	
	String expectedTextForTheSignUp = "YOUR ACCOUNT HAS BEEN CREATED!";
	
	String TheLogoutMessage = "You have been logged off your account. It is now safe to leave the computer.";
	
	String welcomemessage = "Welcome back " + TheFirstName;
}
