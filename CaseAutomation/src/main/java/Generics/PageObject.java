package Generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generics.PageObject;

public abstract class PageObject {
	protected static WebDriver driver;
	protected WebDriverWait wait;
	
	public PageObject (WebDriver driver) {
		PageObject.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
}
