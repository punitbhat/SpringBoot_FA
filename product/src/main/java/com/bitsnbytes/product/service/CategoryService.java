package com.bitsnbytes.product.service;

import org.springframework.stereotype.Service;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.mapper.CategoryMapper;
import com.bitsnbytes.product.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

	
	private CategoryRepository categoryRepository;
	// create category
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = CategoryMapper.toCategoryEntity(categoryDTO);
		category = categoryRepository.save(category);
		return CategoryMapper.toCategoryDTO(category);
		
	}
	// get category
	// get category by id
	// delete category
	
}
