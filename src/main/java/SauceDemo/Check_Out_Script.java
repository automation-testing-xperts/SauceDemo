package SauceDemo;

import org.openqa.selenium.chrome.ChromeDriver;

public class Check_Out_Script {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		// User Names & Passwords
		String StandardUser = "standard_user";
		String Password ="secret_sauce";
		
		//Enters User name and Password for Valid User
		driver.findElementByName("user-name").sendKeys(StandardUser);
		driver.findElementByName("password").clear();
		driver.findElementByName("password").sendKeys(Password);
		
		//Click Login Button
		driver.findElementByName("login-button").click();
		

		//Add All Items To Cart
		driver.findElementById("add-to-cart-sauce-labs-backpack").click();
		driver.findElementById("add-to-cart-sauce-labs-bike-light").click();
		driver.findElementById("add-to-cart-sauce-labs-bolt-t-shirt").click();
		driver.findElementById("add-to-cart-sauce-labs-fleece-jacket").click();
		driver.findElementById("add-to-cart-sauce-labs-onesie").click();
		driver.findElementById("add-to-cart-test.allthethings()-t-shirt-(red)").click();
		
		//Click Shopping Cart
		driver.findElementById("shopping_cart_container").click();
		
		//Click Checkout
		driver.findElementByName("checkout").click();
		
		//Enters Contact Details and Click Continue
		driver.findElementByName("firstName").sendKeys("Kyle");
		driver.findElementByName("lastName").sendKeys("Crawford");
		driver.findElementByName("postalCode").sendKeys("78232");

		driver.findElementByName("continue").click();

		//Clicks Finish On CHECKOUT: OVERVIEW
		driver.findElementByName("finish").click();
		
		//CHECKOUT: COMPLETE!
		//Verifies that the order was successful by verifying that the Pony Express Logo is displayed.
		System.out.println("Order Complete");
		System.out.println(driver.findElementByClassName("pony_express").isDisplayed());

		driver.close();

		
	}
}