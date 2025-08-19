package com.deepak.springbootEcom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deepak.springbootEcom.model.Product;
import com.deepak.springbootEcom.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {

		product.setImageName(image.getOriginalFilename());
		product.setImageType(image.getContentType());
		product.setImageData(image.getBytes());

		return repo.save(product);
	}

	public Product getImageByProductId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public void deleteByProductId(int id) {
		repo.deleteById(id);

	}

	public List<Product> searchProducts(String keyword) {

		return repo.searchProducts(keyword);
	}

}
