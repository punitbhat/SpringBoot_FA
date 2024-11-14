package com.bitsnbytes.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
	
	//@Autowired
	private CategoryService categoryService;

	// get all categories
	// create categories
	@PostMapping
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
		return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
		
	}
	// get category by id
	// delete category
	
}