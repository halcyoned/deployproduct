package org.generation.deployproduct.controller.DTO;


public class ProductDTO {

    private String name;
    private String description;
    private double price;
    private String image_url;
    private String category;

    public ProductDTO(String name, String description, double price, String image_url, String category)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.category = category;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return this.price; }
    public void setPrice (double price) { this.price = price; }

    public String getImage_url() { return this.image_url; }
    public void setImage_url(String image_url) { this.image_url = image_url; }

    public String getCategory() { return this.category; }
    public void setCategory (String category) { this.category = category; }

}


