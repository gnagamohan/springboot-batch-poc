package com.iambeginner.spring.job001;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iambeginner.spring.converter.LineConverter;
import com.iambeginner.spring.domain.Product;

@Component
public class Job001Reader implements ItemReader<Product>{
	private int counter = 0;
	
	private String[] products = {
			"100,Pen,10.0",
			"101,Pencil,5.0",
			"102,Book,100.0",
			"103,Table,2000.0",
			"104,Chair,700.0",
			"105,Mouse,1000.0",
			"106,Pendrive,600.0",
			"107,A4 Paper bunble,4000.0",
			"108,Laptop,30000.0",
			"109,Keyboard,700.0",
			"110,Speakers,3000.0",
			"111,Bluetooth Device,10.0",
			"112,Sketch Pen,100.0",
	};

	
	@Autowired
	private LineConverter lineConverter;
	
	@Override
	public Product read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(counter < products.length){
			return lineConverter.convert(products[counter++], ",");
		}else{
			counter = 0;
		}
		return null;
	}

}
