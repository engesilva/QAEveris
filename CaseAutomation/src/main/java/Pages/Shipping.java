package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Generics.GenericMethods;
import Generics.PageObject;

public class Shipping extends PageObject {
	GenericMethods gem;

	public Shipping(WebDriver driver) {
		super(driver);
		gem = new GenericMethods(driver);
	}
	
	@FindBy(how = How.ID, using = "cgv")
	protected WebElement terms;
	
	@FindBy(how = How.XPATH, using = "//div[@class='delivery_option_price']")
	protected WebElement price;

	@FindBy(how = How.NAME, using = "processCarrier")
	protected WebElement processCarrier;

	public void setTerms() {
		terms.click();
	}

	public double getPriceShipping() {
		return Double.parseDouble(price.getText().replace("$", ""));
	}
	
	public void clickOnProcessCarrier() {
		processCarrier.click();
	}
		
}
