package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Generics.GenericMethods;
import Generics.PageObject;

public class Address extends PageObject {
	GenericMethods gem;

	public Address(WebDriver driver) {
		super(driver);
		gem = new GenericMethods(driver);
	}
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/div[2]/div[1]/ul[1]/li[3]")
	protected WebElement deliveryAddress;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/div[2]/div[1]/ul[1]/li[4]")
	protected WebElement deliveryCityStatePostcode;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/div[2]/div[2]/ul[1]/li[3]")
	protected WebElement billingAddress;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/div[2]/div[2]/ul[1]/li[4]")
	protected WebElement billingCityStatePostcode;
	
	@FindBy(how = How.NAME, using = "processAddress")
	protected WebElement processAddress;


	public String getDeliveryAddress() {
		return deliveryAddress.getText();
	}	

	public String getDeliveryCityStatePostcode() {
		return deliveryCityStatePostcode.getText();
	}	

	public String getBillingAddress() {
		return billingAddress.getText();
	}	

	public String getBillingCityStatePostcode() {
		return billingCityStatePostcode.getText();
	}	
	
	public void clickOnProcessAddress() {
		processAddress.click();
	}	
	
			
}
