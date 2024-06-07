package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents  {
	
	
	WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	By productsBy = By.cssSelector(".mb-3");
	
	By toastMessage =   By.cssSelector("#toast-container");
	
	By invisibilityMessage =  By.cssSelector(".ng-tns-c31-1");
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	
	// Get the products in a list 
	
	public List<WebElement> getProductList()
	
	{
		
		
		waitForTheElementToAppear(productsBy);
		
		return products;
		
	}
	
	public WebElement getProductByName(String productName) {
	
	WebElement prod = getProductList().stream()
			.filter(product -> product.findElement(By.tagName("b")).getText().equals("ADIDAS ORIGINAL")).findFirst()
			.orElse(null);
	
	return prod;
	
	}
	
	public void addProductToCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		
		prod.findElement(addToCart).click();
		
		waitForTheElementToAppear(toastMessage);
		
		waitForTheElementToDisappear(invisibilityMessage);
		
		
		
		
	}

	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-1")));



	

}
