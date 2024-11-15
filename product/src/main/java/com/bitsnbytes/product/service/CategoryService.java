package com.bitsnbytes.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

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
	public List<CategoryDTO> getAllCategories(){
		return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).collect(Collectors.toList());
		
	}

	// get category by id
	public CategoryDTO getCategoryById(Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
		return CategoryMapper.toCategoryDTO(category);
	}
	
	// delete category
	public String deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return "Category: "+ id +" successfully deleted";
		
	}
	
}
