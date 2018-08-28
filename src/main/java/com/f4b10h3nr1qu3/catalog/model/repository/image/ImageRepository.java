package com.f4b10h3nr1qu3.catalog.model.repository.image;

import java.util.List;

import com.f4b10h3nr1qu3.catalog.model.domain.image.Image;
import com.f4b10h3nr1qu3.catalog.model.domain.image.ImageProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = ImageProjection.class)
public interface ImageRepository extends JpaRepository<Image, Long> {

	List<Image> findOneByIdAndProductId(Long productId, Long id);

}
