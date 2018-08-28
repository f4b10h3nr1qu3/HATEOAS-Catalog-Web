package com.f4b10h3nr1qu3.catalog.configs;

import com.f4b10h3nr1qu3.catalog.model.domain.image.Image;
import com.f4b10h3nr1qu3.catalog.model.domain.product.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class ExposeEntityIdRestConfiguration extends RepositoryRestConfigurerAdapter {
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Product.class, Image.class);
	}
}
