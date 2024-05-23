package com.example.crudApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudApplication.entity.Product;
import com.example.crudApplication.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//Post Methods
	public Product saveProduct(Product product) {
		 return productRepository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		 return productRepository.saveAll(products);
	}
	
	//Get Methods
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int id){
		return productRepository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name){
		return productRepository.findByName(name);
	}
	
	//Delete Methods
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product Deleted " + id ;
	}
	
	//Update Method
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
	}
	
}

