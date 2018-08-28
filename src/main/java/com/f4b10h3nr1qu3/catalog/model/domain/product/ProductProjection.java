package com.f4b10h3nr1qu3.catalog.model.domain.product;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "default", types = { Product.class })
public interface ProductProjection {

	Long getId();

	String getName();

	String getDescription();

	Product getParentProduct();

}
