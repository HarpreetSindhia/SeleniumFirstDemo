package rahulshettyacademy;

import io.github.bonigarcia.wdm.WebDriverManager;



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



	public class Copy_Code {

	public static void main(String[] args) {



	WebDriverManager.chromedriver().setup();



	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



	driver.manage().window().maximize();



	driver.get("https://rahulshettyacademy.com/client/");



	driver.findElement(By.cssSelector("#userEmail")).sendKeys("harrysindhia@gmail.com");



	driver.findElement(By.cssSelector("#userPassword")).sendKeys("harry@Code5");



	driver.findElement(By.cssSelector("input[value='Login']")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));



	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));



	WebElement prod = products.stream()

	.filter(product -> product.findElement(By.tagName("b")).getText().equals("ADIDAS ORIGINAL")).findFirst()

	.orElse(null);



	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();



	



	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-1")));



	driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();



	List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));



	Boolean match = cartProduct.stream().anyMatch(cartpro -> cartpro.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));



	Assert.assertTrue(match);


	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));

	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Select Country']")));



	driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");

	List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item:nth-of-type(2)"));



	for (WebElement country : countries) {



	if (country.getText().equalsIgnoreCase("India")) {



	country.click();

	}

	}

	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='action__submit']")));

	//driver.findElement(By.cssSelector("a[class='action__submit']")).click();
	
	
	driver.findElement(By.cssSelector(".btnn")).click();
	
	
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	
	driver.close();

	}

	}


