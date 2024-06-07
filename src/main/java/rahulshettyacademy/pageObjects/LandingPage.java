package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	//WebElement userName = driver.findElement(By.cssSelector("#userEmail"));
	
	//PageFactory
	
	@FindBy(css="#userEmail")
	WebElement userName;
	
	//WebElement password = driver.findElement(By.cssSelector("#userPassword"));
	
	@FindBy(css="#userPassword")
	WebElement password1;
	
	//WebElement submit = driver.findElement(By.cssSelector("input[value='Login']"));
	
	@FindBy(css="input[value='Login']")
	WebElement submit;
	
	
	public void loginApplication(String email , String password) {
		
		userName.sendKeys(email);
		
		password1.sendKeys(password);
		
		submit.click();
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");
	}
	

}
