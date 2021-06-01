package org.generation.deployproduct.controller.DTO.

public class productColorDTO {

    private int Product_Product_code;
    private String color;

    public productColorDTO(int Product_Product_code, String color)
    {
        this.productColorCode = Product_Product_code;
        this.color = color;

    public String getProductCode() {return Product_Product_code;}

    public void setName(String name) {this.name = name; }

    public String getDescription() {return description; }

    public void setDescription(String description) {this.description = description;}

    public String getImageUrl() {return image_url; }

    public void setImageUrl(String imageUrl) {this.imageUrl = image_url; }

    public void setCategory (String category) {this.category = category; }

    public String getCategory() {return category; }

    public void setPrice (double price) {this.price = price; }

    public double getPrice() {return price; }
}
