package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Generics.GenericMethods;
import Generics.PageObject;

public class SingInPersonalInformation extends PageObject {
	GenericMethods gem;

	public SingInPersonalInformation(WebDriver driver) {
		super(driver);
		gem = new GenericMethods(driver);
	}
	
	@FindBy(how = How.ID, using = "customer_firstname")
	protected WebElement customeFirstname;
	
	@FindBy(how = How.ID, using = "customer_lastname")
	protected WebElement customerLastname;
	
	@FindBy(how = How.ID, using = "email")
	protected WebElement email;
	
	@FindBy(how = How.ID, using = "passwd")
	protected WebElement passwd;

	@FindBy(how = How.ID, using = "firstname")
	protected WebElement firstname;

	@FindBy(how = How.ID, using = "lastname")
	protected WebElement lastname;

	@FindBy(how = How.ID, using = "address1")
	protected WebElement address;

	@FindBy(how = How.ID, using = "city")
	protected WebElement city;

	@FindBy(how = How.ID, using = "id_state")
	protected WebElement state;

	@FindBy(how = How.ID, using = "postcode")
	protected WebElement postcode;

	@FindBy(how = How.ID, using = "id_country")
	protected WebElement country;

	@FindBy(how = How.ID, using = "phone_mobile")
	protected WebElement phoneMobile;

	@FindBy(how = How.ID, using = "alias")
	protected WebElement alias;

	@FindBy(how = How.ID, using = "submitAccount")
	protected WebElement submitAccount;
	
	public void setCustomeFirstname(String firstname) {
		wait.until(ExpectedConditions.elementToBeClickable(customeFirstname));
		customeFirstname.sendKeys(firstname);
	}

	public void setCustomerLastname(String lastname) {
		customerLastname.sendKeys(lastname);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setPasswd(String password) {
		passwd.sendKeys(password);
	}
  
	public void setFirstname(String firstname) {
		this.firstname.sendKeys(firstname);
	}
	
	public void setLastname(String lastname) {
		this.lastname.sendKeys(lastname);
	}
	
	public void setAddress(String address) {
		this.address.sendKeys(address);
	}
	
	public void setCity(String city) {
		this.city.sendKeys(city);
	}
  
	public void setState(String state) {
		gem.selectByVisibleText(this.state, state);
	}
  
	public void setPostcode(String postcode) {
		this.postcode.sendKeys(postcode);
	}

	public void setCountry(String country) {
		gem.selectByVisibleText(this.country, country);
	}
	
	public void setPhoneMobile(String number) {
		phoneMobile.sendKeys(number);
	}
	
	public void setAlias(String alias) {
		this.alias.clear();
	    this.alias.sendKeys(alias);
	}
	
	public void clickOnSubmitAccount() {
		submitAccount.click();
	}
	
	public void setCompleteForm(String firstname, String lastname, String password, String address, String city, String state, String postcode, String country, String number, String alias) {
		setCustomeFirstname(firstname);
		setCustomerLastname(lastname);
		setPasswd(password);
		setAddress(address);
		setCity(city);
		setState(state);
		setPostcode(postcode);
		setCountry(country);
		setPhoneMobile(number);
		setAlias(alias);
	}

}