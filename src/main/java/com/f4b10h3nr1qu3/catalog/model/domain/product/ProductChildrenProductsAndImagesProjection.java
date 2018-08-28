package com.f4b10h3nr1qu3.catalog.model.domain.product;

import com.f4b10h3nr1qu3.catalog.model.domain.image.Image;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "childrenProductsAndImages", types = { Product.class })
public interface ProductChildrenProductsAndImagesProjection {

	Long getId();

	String getName();

	String getDescription();

	Product getParentProduct();

	List<Product> getChildProducts();

	List<Image> getImages();

}
