package com.f4b10h3nr1qu3.catalog.controller.product;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.f4b10h3nr1qu3.catalog.configs.CatalogWebApplication;
import com.f4b10h3nr1qu3.catalog.model.domain.product.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogWebApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductRestControllerPutTest {

	@LocalServerPort
	private int port;

	private String toJson(Product product) {
		Gson jsonBuilder = new GsonBuilder().create();
		return jsonBuilder.toJson(product);
	}

	@Sql({"classpath:clean-data.sql", "classpath:insert-data.sql"})
	@Test
	public void testPutSuccess() {

		Product product = new Product();
		product.setName("PS4 Pro");
		product.setDescription("PlayStation 4 Pro 4k");

		String json = toJson(product);

		given().contentType("application/json").body(json).when()
				.put("http://localhost:" + port + "/catalog/products/2").then().statusCode(200)
				.body("name", equalTo("PS4 Pro")).body("description", equalTo("PlayStation 4 Pro 4k")).body("id", equalTo(2));

	}
}
