package com.deepak.springbootEcom.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Component
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String brand;
	private BigDecimal price;
	private String category;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date releaseDate;
	private boolean productAvailable;
	private int stockQuantity;

	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageData;

//	Constructor .......................................................................................
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String description, String brand, BigDecimal price, String category,
			Date releaseDate, boolean productAvailable, int stockQuantity, String imageName, String imageType,
			byte[] imageData) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.releaseDate = releaseDate;
		this.productAvailable = productAvailable;
		this.stockQuantity = stockQuantity;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}

//	Getter Setter Methods........................................................................

//	Id___________________________
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	Name_________________________
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	Desc_________________________
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	Brand_________________________
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

//	Price_________________________
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

//	Category_________________________
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	Date___________________________
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

//	 IsAvailable___________________________
	public boolean isProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}

//	Quantity_____________________________
	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

//	Image Name___________________________
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

//	Image Type___________________________
	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

//	Image Data___________________________
	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

}
