package com.graduation_project.demo.services;

import com.graduation_project.demo.entity.Product;
import com.graduation_project.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService{
	@Autowired //
	public final ProductRepository productRepository;

    public AdminService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
		productRepository.save(product);

	}
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	public String getText() {
		return "Admin";
	}
}
