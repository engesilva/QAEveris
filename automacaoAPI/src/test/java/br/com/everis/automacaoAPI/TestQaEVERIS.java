package br.com.everis.automacaoAPI;
import static io.restassured.RestAssured.*;
import org.junit.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;


public class TestQaEVERIS {
	@Test
	public void exercicio() {
			
			given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://httpbin.org/get")
		.then()		
			.statusCode(200)// O status http retornado foi 200			
			.contentType(ContentType.JSON) // O response foi retornado no formato JSON	
			.body("url", equalTo("https://httpbin.org/get"))
		    .log()
		    .all();		
	}
}
