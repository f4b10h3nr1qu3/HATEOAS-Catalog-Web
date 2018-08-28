package com.f4b10h3nr1qu3.catalog.controller.product;

import com.f4b10h3nr1qu3.catalog.model.domain.product.Product;
import com.f4b10h3nr1qu3.catalog.model.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ExposesResourceFor;

@RepositoryRestController
@ExposesResourceFor(Product.class)
public class ProductRestController {

	@Autowired
	private final ProductRepository repository = null;

	// custom implementations if necessary.
}
