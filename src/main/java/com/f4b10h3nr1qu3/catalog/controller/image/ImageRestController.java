package com.f4b10h3nr1qu3.catalog.controller.image;

import com.f4b10h3nr1qu3.catalog.model.domain.image.Image;
import com.f4b10h3nr1qu3.catalog.model.repository.image.ImageRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ExposesResourceFor;

@RepositoryRestController
@ExposesResourceFor(Image.class)
public class ImageRestController {

	private final ImageRepository repository = null;

	// custom implementations here
}
