package com.example.crudApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudApplication.entity.Product;
import com.example.crudApplication.repository.ProductRepository;
import com.example.crudApplication.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
//	@Autowired
//	private ProductRepository productRepository;
	
	//Post APIs
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
		
	}
	
	@PostMapping("/addproducts")
	public List <Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveProducts(products);
		
	}
	
	//Get APIs
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	//Update APIs
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
		
	}
	
//Delete APIs 
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		 productService.deleteProduct(id);
		 return " Product deleted Successfully " + id;
		
	}
}
