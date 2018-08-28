package com.f4b10h3nr1qu3.catalog.test;

import com.f4b10h3nr1qu3.catalog.controller.image.ImageRestControllerDeleteTest;
import com.f4b10h3nr1qu3.catalog.controller.image.ImageRestControllerGetTest;
import com.f4b10h3nr1qu3.catalog.controller.image.ImageRestControllerPostTest;
import com.f4b10h3nr1qu3.catalog.controller.image.ImageRestControllerPutTest;
import com.f4b10h3nr1qu3.catalog.controller.product.ProductRestControllerDeleteTest;
import com.f4b10h3nr1qu3.catalog.controller.product.ProductRestControllerGetTest;
import com.f4b10h3nr1qu3.catalog.controller.product.ProductRestControllerPostTest;
import com.f4b10h3nr1qu3.catalog.controller.product.ProductRestControllerPutTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ProductRestControllerPostTest.class,
	ProductRestControllerPutTest.class,
	ProductRestControllerDeleteTest.class,
	ProductRestControllerGetTest.class,
	ImageRestControllerPostTest.class,
	ImageRestControllerPutTest.class,
	ImageRestControllerDeleteTest.class,
	ImageRestControllerGetTest.class,
})
public class SuiteAppTest {

}
