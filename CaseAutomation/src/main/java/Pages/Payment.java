package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Generics.GenericMethods;
import Generics.PageObject;

public class Payment extends PageObject {
	GenericMethods gem;

	public Payment(WebDriver driver) {
		super(driver);
		gem = new GenericMethods(driver);
	}
	
	@FindBy(how = How.ID, using = "total_product")
	protected WebElement totalProduct;
	
	@FindBy(how = How.ID, using = "total_shipping")
	protected WebElement totalShipping;

	@FindBy(how = How.ID, using = "total_price")
	protected WebElement totalPrice;

	@FindBy(how = How.XPATH, using = "//a[@title='Pay by bank wire']")
	protected WebElement payByBankWire;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I confirm my order')]")
	protected WebElement confirmOrder;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]/strong[1]")
	protected WebElement confirmation;
	
	public double getTotalProducts() {
		return Double.parseDouble(totalProduct.getText().replace("$", ""));
	}	
	
	public double getTotalShipping() {
		return Double.parseDouble(totalShipping.getText().replace("$", ""));
	}	
	
	public double getTotalPrice() {
		return Double.parseDouble(totalPrice.getText().replace("$", ""));
	}	
	
	public void clickOnPayByBankWire() {
		payByBankWire.click();
	}	
	
	public void clickOnConfirmOrder() {
		confirmOrder.click();
	}	
	
	public String getConfirmation() {
		return confirmation.getText();
	}	

	
}
