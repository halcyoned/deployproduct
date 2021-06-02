package org.generation.deployproduct.repository.Entity;

import org.generation.deployproduct.controller.DTO.ProductDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Product_code;
    private String name;
    private String description;
    private double price;
    private String image_url;
    private String category;

    public Product() {}

    public Product(ProductDTO productDTO) {
        this.name = productDTO.getName();
        this.description = productDTO.getDescription();
        this.image_url = productDTO.getImage_url();
        this.category = productDTO.getCategory();
        this.price = productDTO.getPrice();
    }

    public int getProduct_code() { return this.Product_code; }
    public void setProduct_code(int product_code) { this.Product_code = product_code; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return this.image_url; }
    public void setImage_url(String image_url) { this.image_url = image_url; }

    public String getCategory() { return this.category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return this.price; }
    public void setPrice(double price) { this.price = price; }


    @Override
    public String toString() {
        return String.format("Product{Product_code='%d', name='%s', description='%s', image_url='%s', category='%s', price='%.2f'",
                this.Product_code, this.name, this.description, this.image_url, this.category, this.price);
    }

}
