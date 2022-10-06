package SauceDemo;

import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Script {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		// User Names & Passwords
		String StandardUser = "standard_user";
		String LockedUser = "locked_out_user";
		String InvalidUser = "invalid_user";
		String Password ="secret_sauce";
		
		//Enters User name and Password for Locked User
		driver.findElementByName("user-name").sendKeys(LockedUser);
		driver.findElementByName("password").sendKeys(Password);
		driver.findElementByName("login-button").click();
	
		//Verifies that the Error Button displays that contains Locked User
		System.out.println("Locked User");
		System.out.println(driver.findElementByClassName("error-button").isDisplayed());
		
		
		//Clears User name and password fields		
		driver.findElementByName("user-name").clear();
		driver.findElementByName("password").clear();
		
		//Enters User name and Password for Invalid User
		driver.findElementByName("user-name").sendKeys(InvalidUser);
		driver.findElementByName("password").sendKeys(Password);
		driver.findElementByName("login-button").click();
		
		//Verifies that the Error Button displays that contains Locked User
		System.out.println("Invalid User");
		System.out.println(driver.findElementByClassName("error-button").isDisplayed());
		
		//Clears User name and password fields	
		driver.findElementByName("user-name").clear();
		driver.findElementByName("password").clear();
		
		//Enters User name and Password for Valid User
		driver.findElementByName("user-name").sendKeys(StandardUser);
		driver.findElementByName("password").clear();
		driver.findElementByName("password").sendKeys(Password);
		
		//Click Login Button
		driver.findElementByName("login-button").click();
		
		//Verifies that user is on the SwagLabs Product Screen by verifying the SwagLabs Logo exists
		System.out.println("Products");
		System.out.println(driver.findElementByClassName("app_logo").isDisplayed());
		
		driver.close();
	}
}