package rahulshettyacademy;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Registration_User2 {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.cssSelector(".btn1")).click();
		
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Harry");
		
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Sindhia");
		
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("harrycoder@gmail.com");
		
		driver.findElement(By.cssSelector("#userMobile")).sendKeys("9876486939");
		
		WebElement staticdropdown = driver.findElement(By.cssSelector(".custom-select"));
		
		Select dropdown = new Select(staticdropdown);
		
		dropdown.selectByValue("2: Student");
		
		driver.findElement(By.cssSelector("input[value='Female']")).click();
		
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("harryCode@5");
		
		driver.findElement(By.cssSelector("#confirmPassword")).sendKeys("harryCode@5");
		
		driver.findElement(By.cssSelector("input[formcontrolname='required']")).click();
		
		driver.findElement(By.cssSelector("input[value='Register']")).click();
		
		
		
		
		
		
	}

}
