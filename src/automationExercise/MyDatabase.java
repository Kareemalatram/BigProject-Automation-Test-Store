package automationExercise;
import java.util.Random;

public class MyDatabase {
	
	Random rand =new Random();
	
	String [] myNames = {"Ahmad" , "Taymoor" , "Kareem" , "Leen" , "thuraia" , "layan"};
	
	String [] lastNames = {"Aboud" , "Ahmad" , "Ali" , "Kareem" , "Shareef" , "Ammar"};

	int RandomLastNameIndex = rand.nextInt(lastNames.length);
	
	String TheLastName = lastNames[RandomLastNameIndex];
	
	String TheAddressOne = "New York";
	
	String TheState = "New York";
	
	String TheCity = "New York City";
	
	String ZipCode = "11181";
	
	String MobileNumber = "0798348684";
	
	int RandomNumberForTheEmail = rand.nextInt(22569);
	
	String domain = "@gmail.com";
	
	int randomTheNameIndex = rand.nextInt(myNames.length);

	String TheMainName = myNames[randomTheNameIndex];
	
	String TheEmail = TheMainName + RandomNumberForTheEmail + domain;
	
	String Password = "P@$$w0rd";
	
	String[] titles = {"Mr", "Mrs"};
	
	String CardName = TheMainName;
	
	String CardNo = "4458901674387467";
	
	String CVC = "461";
	
	String ExpirationMonth = "06";
	
	String ExpirationYear = "2027";
	
	String randomTitle = titles[new Random().nextInt(titles.length)];
	
	int theSelectDayIndex = rand.nextInt(1 , 25);

	int theSelectMonthIndex = rand.nextInt(1 , 10);
	
	int theSelectYearIndex = rand.nextInt(1 , 40);
	
	String ExpectedTextForTheSignUp = "Congratulations! Your new account has been successfully created!";

	String ExceptedTestForPaymentSucess = "Congratulations! Your order has been confirmed!";
	

	
}
