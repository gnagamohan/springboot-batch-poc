package com.iambeginner.spring.converter;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.iambeginner.spring.domain.Product;

@Component
public class LineConverter {
	public Product convert(String line, String delimiter){
		String[] tokens = line.split(delimiter);
		if(tokens.length == 3){
			Product product = new Product();
			product.setId(tokens[0]);
			product.setDisplayName(tokens[1]);
			product.setPrice(new BigDecimal(tokens[2]));
			return product;
		}
		return null;
	}
}
