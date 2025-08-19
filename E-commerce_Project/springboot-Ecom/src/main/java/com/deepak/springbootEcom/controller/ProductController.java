package com.deepak.springbootEcom.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deepak.springbootEcom.model.Product;
import com.deepak.springbootEcom.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
		Product product = service.getProductById(id);
		if (product != null)
			return new ResponseEntity<>(product, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/product/search/{keyword}")
	public ResponseEntity<List<Product>> searchProducts(@RequestPart String keyword) {
		List<Product> products = service.searchProducts(keyword);
		if (products != null)
			return new ResponseEntity<>(products, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/product/{id}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable("id") int id) {
		Product product = service.getProductById(id);
		if (product.getImageData() != null)
			return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteByProductId(@PathVariable("id") int id) {
		Product product = service.getProductById(id);
		if (product != null) {
			service.deleteByProductId(id);
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product,
			@RequestPart MultipartFile imageFile) {
		Product updateProduct = null;
		try {
			updateProduct = service.addOrUpdateProduct(product, imageFile);
			return new ResponseEntity<>("Updated", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart("product") Product product,
			@RequestPart("imageFile") MultipartFile imageFile) {

		System.out.println("add Product called... ");
		Product savedProduct;
		try {
			savedProduct = service.addOrUpdateProduct(product, imageFile);
			return new ResponseEntity<>(savedProduct, HttpStatus.ACCEPTED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
