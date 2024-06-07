package rahulshettyacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageObjects.LandingPage;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest_2 {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/client/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.cssSelector("#userEmail")).sendKeys("harrysindhia@gmail.com");
		
		LandingPage landingPage = new LandingPage(driver);

		driver.findElement(By.cssSelector("#userPassword")).sendKeys("harry@Code5");

		driver.findElement(By.cssSelector("input[value='Login']")).click();

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equals("ADIDAS ORIGINAL")).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-1")));

		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = cartProduct.stream().anyMatch(cartpro -> cartpro.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));

		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
	
		List<WebElement> countries = driver.findElements(By.xpath("//section/button"));

		for (WebElement country : countries) {

			if (country.getText().equalsIgnoreCase("India")) {

				country.click();
			}
			
			
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='action__submit']")));
		driver.findElement(By.cssSelector("a[class='action__submit']")).click();
		
	}
}
		

		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".actions a")));

		driver.findElement(By.cssSelector(".actions a")).click();*/

		/*
		 * List<WebElement> products =
		 * driver.findElements(By.cssSelector(".card-body h5"));
		 * 
		 * WebElement prod =
		 * products.stream().filter(product->product.findElement(By.tagName("b")).
		 * getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		 * 
		 * //prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
		 * 
		 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 * 
		 * 
		 * 
		 * 
		 * //String newList =
		 * products.stream().filter(s->s.getText().contains("ADIDAS ORIGINAL")).forEach(
		 * s->System.out.println(s));
		 * 
		 * /*for(int i = 0; i < products.size(); i++) {
		 * 
		 * String actualName = products.get(i).getText();
		 * 
		 * if(actualName.equalsIgnoreCase("ADIDAS ORIGINAL")) {
		 * 
		 * 
		 * driver.findElements(By.cssSelector(".w-10")).get(i).click();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

		/*
		 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(7000));
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//ul/li[4]/button")));
		 * 
		 * driver.findElement(By.xpath("//ul/li[4]/button")).click();
		 * 
		 * driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		 */

	


