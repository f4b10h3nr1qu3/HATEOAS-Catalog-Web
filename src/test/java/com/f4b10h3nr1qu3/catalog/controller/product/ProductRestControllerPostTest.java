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
public class ProductRestControllerPostTest {

	@LocalServerPort
	private int port;

	private String toJson(Product product) {
		Gson jsonBuilder = new GsonBuilder().create();
		return jsonBuilder.toJson(product);
	}

	@Sql({ "classpath:clean-data.sql", "classpath:insert-data.sql" })
	@Test
	public void testPostSuccess() {

		Product product = new Product();
		product.setName("PS3 Slim");
		product.setDescription("PlayStation 3 Slim");

		String json = toJson(product);

		given().contentType("application/json").body(json).when().post("http://localhost:" + port + "/catalog/products")
				.then().statusCode(201).body("name", equalTo("PS3 Slim"))
				.body("description", equalTo("PlayStation 3 Slim")).extract().asString();

	}
}
