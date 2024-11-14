package com.bitsnbytes.product.dto;

import java.util.List;

import com.bitsnbytes.product.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

	private Long id;
	private String name;
	private List<ProductDTO> products;
}
