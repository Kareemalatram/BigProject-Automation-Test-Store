  package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends myData {

	WebDriver driver = new EdgeDriver();

	String myWebSite = "https://automationteststore.com/";

	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

	@BeforeTest

	public void mySetup() {

		driver.get(myWebSite);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1, enabled = false)

	public void SignupTest() throws InterruptedException {

		driver.navigate().to(SignupPage);

		// WebElements
		WebElement FirstName = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement Email = driver.findElement(By.id("AccountFrm_email"));
		WebElement TelePhone = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement TheFax = driver.findElement(By.id("AccountFrm_fax"));
		WebElement AddressOne = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement TheCountry = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement ThePostalCode = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement ThePassword = driver.findElement(By.id("AccountFrm_password"));
		WebElement ThePasswordConfirm = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement AgreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));

		Select mySelectElementForCountry = new Select(TheCountry);
		Select mySelectElementForState = new Select(TheState);

		mySelectElementForCountry.selectByIndex(108);
		Thread.sleep(2000);
		mySelectElementForState.selectByIndex(theSelectStateIndex);

		List<WebElement> AlltheStates = TheState.findElements(By.tagName("option"));

		String theCity = AlltheStates.get(theSelectStateIndex).getText();

		WebElement TheCityInput = driver.findElement(By.id("AccountFrm_city"));

		// -- Actions --
		FirstName.sendKeys(TheFirstName);
		LastName.sendKeys(TheLastName);
		Email.sendKeys(TheEmail);
		TelePhone.sendKeys(telePhone);
		TheFax.sendKeys(TheFaxNumber);
		AddressOne.sendKeys(TheAddressOne);
		TheCityInput.sendKeys(theCity);
		ThePostalCode.sendKeys(postalCode);
		LoginName.sendKeys(LOGINNAME);
		ThePassword.sendKeys(Password);
		ThePasswordConfirm.sendKeys(Password);
		AgreeCheckBox.click();
		ContinueButton.click();

		Thread.sleep(5000);
		String ActualSignUpMessage = driver.findElement(By.className("maintext")).getText();

		System.out.println(ActualSignUpMessage);

		// TEST CASE (بتقارن القيمة الحقيقة بالمتوقعة و بتشتغل نفس ال ايف كونديشن)
		Assert.assertEquals(ActualSignUpMessage, expectedTextForTheSignUp);


		
//		//Static
//		String [] firstNames = {"Shatha" , "Ahmad" , "Ali" , "Kareem" , "Leen" , "sana"};
//		
// 		//Dynamic
//		List<String> mycolors = new ArrayList<String>();
//		
//		mycolors.add("Red");
//		mycolors.add("Blue");
//
//		System.out.println(firstNames[0]);
//
//		System.out.println(mycolors.get(0));
	}
	
	@Test(priority = 2 , enabled = false)
	public void LogoutTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logoff")).click();
		
//		System.out.println(driver.getPageSource());
//		String ActualLogOutMessage = driver.findElement(By.className("maintext")).getText();
//
		boolean ActualValueForLogout = driver.getPageSource().contains(TheLogoutMessage);
		
		Assert.assertEquals(ActualValueForLogout, true);
		
	}
	
	
	@Test(priority = 3, enabled = false)
	
	public void Login() throws InterruptedException {
		
		driver.findElement(By.linkText("Login or register")).click();
		
		WebElement LoginNameInput = driver.findElement(By.id("loginFrm_loginname")); 
		
		WebElement LoginPasswordInput = driver.findElement(By.id("loginFrm_password"));
		
		WebElement LoginButton = driver.findElement(By.cssSelector("button[title='Login']"));

		
		LoginNameInput.sendKeys(LOGINNAME);
		LoginPasswordInput.sendKeys(Password);
		
		Thread.sleep(4000);
		LoginButton.click();
		
		boolean ActualValue = driver.getPageSource().contains(welcomemessage);
		
		boolean ExpectedValue = true;
		
		Assert.assertEquals(ActualValue, ExpectedValue);
		
	}
	
	@Test(priority = 4)
	
	public void AddItemToTheCart() {
		driver.navigate().to(myWebSite);
		
		List<WebElement> AllItems = driver.findElements(By.className("prdocutname"));
		
		int RandomIndexForTheItem = rand.nextInt(AllItems.size());

		AllItems.get(RandomIndexForTheItem).click();
		
		
		// LOGIC ONE هاد في حال كان في item out of stock
		
//		if(driver.getCurrentUrl().contains("product_id=116")) {
//			
//			WebElement AvailableOption = driver.findElement(By.id("option344747"));
//			
//			AvailableOption.click();
//		}
		
		// LOGIC TWO  هاد في حال كان في item out of stock
		
		if (driver.getPageSource().contains("Out of Stock") ||driver.getCurrentUrl().contains("product_id=116")){
			
			driver.navigate().back();
			
			List<WebElement> AlternativeItems = driver.findElements(By.className("prdocutname"));
			int AlternativeItem = rand.nextInt(AlternativeItems.size());

			
			AlternativeItems.get(AlternativeItem).click();
			
		}
		
//		int a = 5 ;
//		while(a==5) {
//			System.out.println("yes");
//		}
//		
		
		WebElement AddToCartButton = driver.findElement(By.cssSelector(".cart"));
		
		AddToCartButton.click();
		
	}
  
	@AfterTest

	public void AfterMyTest() {

//		driver.close();

//		driver.quit();
	}

}
