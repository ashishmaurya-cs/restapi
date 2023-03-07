package com.ashish.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.restapi.model.Product;
import com.ashish.restapi.services.ProductServices;

@RestController
public class RestapiController {
	@Autowired
	private ProductServices productServices;
	
	@RequestMapping(value = "/products",method = RequestMethod.GET)
	public List<Product> AllProducts(){
		return  productServices.getAllProducts();
	}
	
	@RequestMapping(value = "/product/{pid}",method = RequestMethod.GET)
	public Product getProduct(@PathVariable String pid) {
		return productServices.getSingleProduct(pid);
		
	}
	
	@RequestMapping(value = "product/add", method = RequestMethod.POST)
	public void addProductToList(@RequestBody Product p) {
		productServices.addProduct(p);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable String id, @RequestBody Product p) {
		productServices.update(id, p);
	}
	
	@RequestMapping(value = "/delete/{pid}",method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable String pid) {
		productServices.delete(pid);
	}
}
