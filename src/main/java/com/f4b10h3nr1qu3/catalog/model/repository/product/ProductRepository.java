package com.f4b10h3nr1qu3.catalog.model.repository.product;

import com.f4b10h3nr1qu3.catalog.model.domain.product.Product;
import com.f4b10h3nr1qu3.catalog.model.domain.product.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = ProductProjection.class)
public interface ProductRepository extends JpaRepository<Product, Long> {

}
