package com.f4b10h3nr1qu3.catalog.model.domain.product;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "childrenProducts", types = { Product.class })
public interface ProductChildrenProjection  {

	Long getId();

	String getName();

	String getDescription();

	Product getParentProduct();
	
	List<Product> getChildProducts();

}
