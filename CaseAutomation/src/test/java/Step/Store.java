package Step;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

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
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Store {
	
	static WebDriver driver;
	static Log log;
	private Double price;
	
	@Dado("^navegador aberto na \"(.*)\" web$")
	public void navegador_aberto_na_web(String url) throws Throwable {
		GenericMethods gem = new GenericMethods();
		gem.getHomePage(url);
		driver = GenericMethods.getDriver();
		log = new Log(driver);
	}
	
	@Dado("\"(.*)\" encontrado$")
	public void encontrado(String item) throws Throwable {
		Home pg_home = new Home(driver);
		SearchResult pg_search_result = new SearchResult(driver);
		pg_home.setSearchItem(item);
		log.screenshot();
		pg_home.clickOnSubmitSearch();

		log.screenshot();
		pg_search_result.clickOnItem(item);
	}
	
	@Quando("^preencho os dados do item com \"(.*)\", \"(.*)\", \"(.*)\"$")
	public void preencho_os_dados_do_item_com(String quantity_wanted, String size, String color) throws Throwable {
		Item pg_item = new Item(driver);
		
		price = pg_item.getPrice()*Double.parseDouble(quantity_wanted);
		
		pg_item.setQuantityWanted(quantity_wanted);
		pg_item.setSize(size);
		pg_item.setColor(color);
		log.screenshot();
	}
	
	@Quando("^adiciono ao carrinho$")
	public void adiciono_ao_carrinho() throws Throwable {
		Item pg_item = new Item(driver);
		CartSummary pg_cart_summary = new CartSummary(driver);
		
		pg_item.clickOnAddToCart();
		log.screenshot();
		pg_item.clickOnProceedToCheckout();

		log.screenshot();
		assertEquals(price, pg_cart_summary.getTotalProducts(), 0);
		pg_cart_summary.clickOnProceedToCheckout();	    
	}
	
	@Quando("^crio uma conta com \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
	public void crio_uma_conta_com(String email, String firstname, String lastname, String password, String address, String city, String state, String postcode, String country, String number, String alias) throws Throwable {
		SingInAuthentication pg_singin_aut = new SingInAuthentication(driver);
		SingInPersonalInformation pg_singin_per_inf = new SingInPersonalInformation(driver);
		Address pg_address = new Address(driver);
		
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
	    
	}
	
	@Quando("^realizo o pagamento via cartao de credito$")
	public void realizo_o_pagamento_via_cartao_de_credito() throws Throwable {

		Shipping pg_shipping = new Shipping(driver);
		Payment pg_payment = new Payment(driver);
		pg_shipping.setTerms();
		double priceShipping = pg_shipping.getPriceShipping();
		log.screenshot();
		pg_shipping.clickOnProcessCarrier();

		log.screenshot();
		assertEquals(price, pg_payment.getTotalProducts(), 0);
		assertEquals(priceShipping, pg_payment.getTotalShipping(), 0);
		assertEquals(price+priceShipping, pg_payment.getTotalPrice(), 0);
		pg_payment.clickOnPayByBankWire();

		log.screenshot();
		pg_payment.clickOnConfirmOrder();		
	}
	
	@Entao("^visualizo a mensagem de sucesso$")
	public void visualizo_a_mensagem_de_sucesso() throws Throwable {
		Payment pg_payment = new Payment(driver);
		log.screenshot();
		Assert.assertEquals("Your order on My Store is complete.", pg_payment.getConfirmation());
	}	
}
