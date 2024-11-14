package com.bitsnbytes.product.mapper;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;

public class CategoryMapper {
	
	// dto to entity
	public static Category toCategoryEntity(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		return category;
	}
	
	// entity to dto
	public static CategoryDTO toCategoryDTO(Category category) {
		if (category == null)
			return null;
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		categoryDTO.setProducts(category.getProducts()
				.stream().map(ProductMapper::toProductDTO).collect(Collectors.toList()));
		
		return categoryDTO;
		
		
	}
	

}
