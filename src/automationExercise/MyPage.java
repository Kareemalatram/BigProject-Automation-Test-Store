package automationExercise;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyPage extends MyDatabase {

	WebDriver driver = new EdgeDriver();
	
	String myWebSite = "https://www.automationexercise.com/";
	
	String mySignUp = "https://www.automationexercise.com/login";
	
	
	
	@BeforeTest()
	
	public void mySetUp() {
		
		driver.get(myWebSite);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	
	
	@Test(priority = 1 ,enabled = true)
	
	public void mySignUpPage() throws InterruptedException {
		
		driver.navigate().to(mySignUp);
		

		//WEBELEMENT
		WebElement Name = driver.findElement(By.cssSelector("input[placeholder='Name']"));
		WebElement Email = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
		WebElement SignupBtn = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
		
		
		//Actions
		Name.sendKeys(TheMainName);
		Email.sendKeys(TheEmail);
		SignupBtn.click();
		
		WebElement mrRadio = driver.findElement(By.id("id_gender1"));  
		WebElement mrsRadio = driver.findElement(By.id("id_gender2")); 
		
		Thread.sleep(2000);
		Random rand = new Random();
		if (rand.nextBoolean()) {
		    mrRadio.click();
		    System.out.println("Selected: Mr");
		} else {
		    mrsRadio.click();
		    System.out.println("Selected: Mrs");
	}


		WebElement ThePassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		ThePassword.sendKeys(Password);
		
		WebElement TheDay = driver.findElement(By.id("days"));
		WebElement TheMonth = driver.findElement(By.id("months"));
		WebElement TheYear = driver.findElement(By.id("years"));
		
		
		Select mySelectElementForDays = new Select(TheDay);
		Select mySelectElementForMonths = new Select(TheMonth);
		Select mySelectElementForYears = new Select(TheYear); 

		// Hon 3shan yakhod nafs al value bshakel 3ashwa2i
		
		mySelectElementForDays.selectByIndex(theSelectDayIndex);
		mySelectElementForMonths.selectByIndex(theSelectMonthIndex);
		mySelectElementForYears.selectByIndex(theSelectYearIndex);
		
		
		// Hon 3shan yakhod nafs al value bel zabt
		
//		mySelectElementForDays.selectByValue("5");
//		mySelectElementForMonths.selectByValue("7");
//		mySelectElementForYears.selectByValue("2000");
		
		
		//WebElement For Address Information
		WebElement FirstName = driver.findElement(By.id("first_name"));
		WebElement LastName = driver.findElement(By.id("last_name"));
		WebElement Address = driver.findElement(By.id("address1"));
		WebElement Country = driver.findElement(By.id("country"));
		WebElement State = driver.findElement(By.id("state"));
		WebElement City = driver.findElement(By.id("city"));
		WebElement Zip = driver.findElement(By.id("zipcode"));
		WebElement MobileNo = driver.findElement(By.id("mobile_number"));
		WebElement CreateAccountBtn = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
		
		Select mySelectElementForTheCountry = new Select(Country);
		
		mySelectElementForTheCountry.selectByValue("United States");
		
		
		//Actions For Address Information
		FirstName.sendKeys(TheMainName);
		LastName.sendKeys(TheLastName);
		Address.sendKeys(TheAddressOne);
		State.sendKeys(TheState);
		City.sendKeys(TheCity);
		Zip.sendKeys(ZipCode);
		MobileNo.sendKeys(MobileNumber);
		CreateAccountBtn.click();
		
		String ActualSignUpMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p[1]")).getText();
		
		System.out.println(ActualSignUpMsg);
		
		Assert.assertEquals(ActualSignUpMsg, ExpectedTextForTheSignUp);
		
		driver.findElement(By.linkText("Continue")).click();
		
		
	}
	
	@Test(priority = 2 , enabled = true)
	
	public void MyLogOutTest() throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
	}
	
	
	@Test(priority = 3 , enabled = true)
	
	public void MyLogin() {
	
	WebElement LoginName = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
	WebElement LoginPass = driver.findElement(By.name("password"));
	WebElement LoginButton = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
	
	LoginName.sendKeys(TheEmail);
	LoginPass.sendKeys(Password);
	LoginButton.click();	
}

	@Test(priority = 4 , enabled = true)
	
		public void AddItemToCart() throws InterruptedException {
		
		Random rand = new Random();
	
			//Here To ADD Random Item 
	    for (int i = 0; i < 29; i++) { 
	        // pick a random item and open it
	        List<WebElement> items = driver.findElements(By.linkText("View Product"));
	        int randomItem = rand.nextInt(items.size());
	        items.get(randomItem).click();
	        
	        driver.findElement(By.cssSelector("button[type='button']"));
	    	
	    	driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
	    	
	    	Thread.sleep(2000);
	    	
//	    	driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();
	    	
	    	driver.findElement(By.linkText("View Cart")).click();
	    	
	    	driver.findElement(By.linkText("Proceed To Checkout")).click();
	    	
	    	WebElement DescriptionMsg = driver.findElement(By.name("message"));
	    	
	    	DescriptionMsg.sendKeys("Hi , I am New Customer Here!.. Please Give Me A Good Packaging!");
	    	
	    	Thread.sleep(3000);
	    	
	    	driver.findElement(By.linkText("Place Order")).click();
	    }
		
	}
	
	
	@Test(priority = 5 , enabled= true)
	
	public void PaymentProcess() throws InterruptedException {
		
		//WebElement
		
		WebElement nameOnCard = driver.findElement(By.cssSelector("input[name='name_on_card']"));
		WebElement CardNumber = driver.findElement(By.name("card_number"));
		WebElement CvcCode = driver.findElement(By.name("cvc"));
		WebElement ExpirationMo = driver.findElement(By.name("expiry_month"));
		WebElement ExpirationYe = driver.findElement(By.name("expiry_year"));
		WebElement PayAndConfirmBtn = driver.findElement(By.id("submit"));
		
		//ACTIONS
		
		nameOnCard.sendKeys(CardName);
		CardNumber.sendKeys(CardNo);
		CvcCode.sendKeys(CVC);
		ExpirationMo.sendKeys(ExpirationMonth);
		ExpirationYe.sendKeys(ExpirationYear);
		PayAndConfirmBtn.click();
		
		String ActualMsgForPaymentSucess = "Congratulations! Your order has been confirmed!";
		
		Assert.assertEquals(ActualMsgForPaymentSucess, ExceptedTestForPaymentSucess);
		
		
		WebElement DownloadInvoice = driver.findElement(By.linkText("Download Invoice"));
		DownloadInvoice.click();
	
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Continue")).click();
	}
	
	
}


