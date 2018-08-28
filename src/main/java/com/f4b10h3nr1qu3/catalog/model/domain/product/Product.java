package com.f4b10h3nr1qu3.catalog.model.domain.product;

import com.f4b10h3nr1qu3.catalog.model.domain.image.Image;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@NotEmpty
	@Column
	@Size(min = 1, max = 40)
	private String name;

	@Column
	@Size(min = 1, max = 100)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "parent_product_id", nullable = true)
	private Product parentProduct;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentProduct")
	@Fetch(FetchMode.SELECT)
	private List<Product> childProducts;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.REMOVE)
	private List<Image> images;

	public Product() {
		super();
	}

	public Product(Long id) {
		super();
		this.id = id;
	}

	public Product(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getParentProduct() {
		return parentProduct;
	}

	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, name='%s', description='%s']", id, name, description);
	}

	public List<Product> getChildProducts() {
		return childProducts;
	}

	public void setChildProducts(List<Product> childProducts) {
		this.childProducts = childProducts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

}
