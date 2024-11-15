package com.bitsnbytes.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.entity.Product;
import com.bitsnbytes.product.mapper.ProductMapper;
import com.bitsnbytes.product.repository.CategoryRepository;
import com.bitsnbytes.product.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	// Create Product
	public ProductDTO createProduct(ProductDTO productDTO) {
		
		/**
		 * id, name, desceription, price, categoryId
		 */
		
		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(()-> new RuntimeException("Category not found"));
		
		// Dto to Entity
		Product product = ProductMapper.toProductEntity(productDTO, category);
		product = productRepository.save(product);
		
		//Entity to DTO
		return ProductMapper.toProductDTO(product);
	}

	//Get Products
	public List<ProductDTO> getAllProducts(){
		return productRepository.findAll().stream().map(ProductMapper::toProductDTO).collect(Collectors.toList());
	}
	
	// Get Product by Id
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Product not found!"));
		return ProductMapper.toProductDTO(product);
	}
	
	// Delete Product by Id
	public String deleteProductById(Long id) {
		productRepository.deleteById(id);
		return "Product:"+id+"is successfully deleted!";
		
	}
	
	// Update Product
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		Product product = productRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Product not found!"));
		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(()-> new RuntimeException("Category not found!"));
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setCategory(category);
		productRepository.save(product);
		return ProductMapper.toProductDTO(product);
		
		
	}
}
