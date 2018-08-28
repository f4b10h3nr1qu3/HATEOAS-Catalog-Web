package com.f4b10h3nr1qu3.catalog.controller.image;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.f4b10h3nr1qu3.catalog.configs.CatalogWebApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
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
public class ImageRestControllerPostTest {

	@LocalServerPort
	private int port;

	@Sql({ "classpath:clean-data.sql", "classpath:insert-data.sql" })
	@Test
	public void testPostSuccess() throws Exception {

		String json = new ObjectMapper().writeValueAsString(ImmutableMap.builder().put("type", "PNG")
				.put("product", "http://localhost:" + port + "/products/" + 1l).build());

		given().contentType("application/json").body(json).when().post("http://localhost:" + port + "/catalog/images")
				.then().statusCode(201).body("type", equalTo("PNG"));

	}
}
