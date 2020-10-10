package com.iambeginner.spring.job001;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.iambeginner.spring.domain.Product;

@Component
public class Job001Writer implements ItemWriter<Product>{

	@Override
	public void write(List<? extends Product> productList) throws Exception {
		System.out.println(productList);
	}

}
