package Runs;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generics.GenericMethods;
import Generics.Log;
import Pages.Address;
import Pages.CartSummary;
import Pages.Home;
import Pages.Item;
import Pages.Payment;
import Pages.SearchResult;
import Pages.Shipping;
import Pages.SingInAuthentication;
import Pages.SingInPersonalInformation;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class RunJUnit {
	
	static WebDriver driver;
	static Home pg_home;
	static SearchResult pg_search_result;
	static Item pg_item;
	static CartSummary pg_cart_summary;
	static SingInAuthentication pg_singin_aut;
	static SingInPersonalInformation pg_singin_per_inf;
	static Address pg_address;
	static Shipping pg_shipping;
	static Payment pg_payment;
	static Log log;
	static GenericMethods gem;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("*******************************");
		System.out.println("*         TESTE INICIADO...      *");
		System.out.println("*******************************");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("*******************************");
		System.out.println("*          TESTE CONCLUIDO        *");
		System.out.println("*******************************");
	}

	@Before
	public void setUp() throws Exception {
		gem = new GenericMethods();
		driver = gem.getDriver();
		
		pg_home = new Home(driver);
		pg_search_result = new SearchResult(driver);
		pg_item = new Item(driver);
		pg_cart_summary = new CartSummary(driver);
		pg_singin_aut = new SingInAuthentication(driver);
		pg_singin_per_inf = new SingInPersonalInformation(driver);
		pg_address = new Address(driver);
		pg_shipping = new Shipping(driver);
		pg_payment = new Payment(driver);
		
		log = new Log(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	public void test() {
		String url = "http://automationpractice.com/index.php";
		String item = "Blouse";
		String quantity_wanted = "10";
		String size = "S";
		String color = "Black";
		double price;
	
		String email = "fhsilvaaa_dev@email.com";
		String firstname = "Flavio";
		String lastname = "Silva";
		String password = "fhssilva123";
		String address = "297 Avenida Brigadeiro Franco, Bigorrilho";
		String city = "New York ";
		String state = "Colorado";
		String postcode = "80010";
		String country = "United States";
		String number = "+5541996379955";
		String alias = "Ref. Addres";
		double priceShipping;
		
		pg_home.getHomePage(url);
		log.screenshot();
		
		pg_home.setSearchItem(item);
		log.screenshot();
		pg_home.clickOnSubmitSearch();

		log.screenshot();
		pg_search_result.clickOnItem(item);
		
		price = pg_item.getPrice()*Double.parseDouble(quantity_wanted);
		
		pg_item.setQuantityWanted(quantity_wanted);
		pg_item.setSize(size);
		pg_item.setColor(color);
		log.screenshot();
		pg_item.clickOnAddToCart();
		log.screenshot();
		pg_item.clickOnProceedToCheckout();

		log.screenshot();
		assertEquals(price, pg_cart_summary.getTotalProducts(), 0);
		pg_cart_summary.clickOnProceedToCheckout();
		
		pg_singin_aut.setEmailCreate(email);
		log.screenshot();
		pg_singin_aut.clickOnCreateAccount();
		
		pg_singin_per_inf.setCompleteForm(firstname, lastname, password, address, city, state, postcode, country, number, alias);
		log.screenshot();
		pg_singin_per_inf.clickOnSubmitAccount();
		
		log.screenshot();
		Assert.assertEquals(address, pg_address.getDeliveryAddress());
		Assert.assertEquals(city+", "+state+" "+postcode, pg_address.getDeliveryCityStatePostcode());
		Assert.assertEquals(address, pg_address.getBillingAddress());
		Assert.assertEquals(city+", "+state+" "+postcode, pg_address.getBillingCityStatePostcode());
		pg_address.clickOnProcessAddress();
		
		pg_shipping.setTerms();
		priceShipping = pg_shipping.getPriceShipping();
		log.screenshot();
		pg_shipping.clickOnProcessCarrier();

		log.screenshot();
		assertEquals(price, pg_payment.getTotalProducts(), 0);
		assertEquals(priceShipping, pg_payment.getTotalShipping(), 0);
		assertEquals(price+priceShipping, pg_payment.getTotalPrice(), 0);
		pg_payment.clickOnPayByBankWire();

		log.screenshot();
		pg_payment.clickOnConfirmOrder();
		
		log.screenshot();
		Assert.assertEquals("Your order on My Store is complete.", pg_payment.getConfirmation());
		
	}

}

