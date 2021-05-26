package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Generics.GenericMethods;
import Generics.PageObject;

public class SearchResult extends PageObject {
	GenericMethods gem;
	
	public SearchResult(WebDriver driver) {
		super(driver);
		gem = new GenericMethods(driver);
	}
	
//	@FindBy(how = How.LINK_TEXT, using = linkText)
//	protected WebElement searchQueryTop;

	public void clickOnItem(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}	
		
}
