package com.f4b10h3nr1qu3.catalog.model.domain.product;

import com.f4b10h3nr1qu3.catalog.model.domain.image.Image;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "images", types = { Product.class })
public interface ProductImagesProjection {

	Long getId();

	String getName();

	String getDescription();

	Product getParentProduct();

	List<Image> getImages();

}
