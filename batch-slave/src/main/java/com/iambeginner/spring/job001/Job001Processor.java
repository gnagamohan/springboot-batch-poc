package com.iambeginner.spring.job001;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.iambeginner.spring.domain.Product;

@Component
public class Job001Processor implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product product) throws Exception {
		return product;
	}

}
