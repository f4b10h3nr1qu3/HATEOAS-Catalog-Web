package com.f4b10h3nr1qu3.catalog.model.domain.image;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "noChildren", types = { Image.class })
public interface ImageProjection {

	Long getId();

	String getType();

}
