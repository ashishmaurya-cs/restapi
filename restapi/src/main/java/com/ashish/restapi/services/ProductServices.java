package com.ashish.restapi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashish.restapi.model.Product;

@Service
public class ProductServices {
	
	private ArrayList<Product> products = new ArrayList<>(
			Arrays.asList(
					new Product("1", "Iphone", "Electronics"),
					new Product("2", "Audi", "Automobile"),
					new Product("3", "Audi", "Automobile"),
					new Product("4", "Audi", "Automobile"),
					new Product("5", "Audi", "Automobile")
					)
			);
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public Product getSingleProduct(String id) {
		return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void update(String id, Product product) {
		for(int i =0;i<products.size();i++) {
			Product p = products.get(i);
			if(p.getId().equals(id)) {
				products.set(i, product);
			}
		}
	}
	
	public void delete(String id) {
//		for(int i =0;i<products.size();i++) {
//			Product p = products.get(i);
//			if(p.getId().equals(id)) {
//				products.remove(i);
//			}
//		}
		products.removeIf(p -> p.getId().equals(id));
	}

}
