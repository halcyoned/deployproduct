package org.generation.deployproduct.controller.DTO.;


public class productDTO {

    private int Product_code;
    private String name;
    private String description;
    private double price;
    private String image_url;
    private String category;

    public productDTO (int Product_code, String name, String description, double price, String image_url, String category)
    {
        this.Product_code = Product_code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.category = category;
    }

    public int Product_code() {return Product_code;}

    public void setProduct_code(String Product_code) {this.Product_code = Product_code; }

    public String getName() {return name;}

    public void setName(String name) {this.name = name; }

    public String getDescription() {return description; }

    public void setDescription(String description) {this.description = description;}

    public void setPrice (double price) {this.price = price; }

    public double getPrice() {return price; }

    public String getImage_url() {return image_url; }

    public void setImage_url(String image_url) {this.image_url = image_url; }

    public void setCategory (String category) {this.category = category;

    public String getCategory() {return category; }


}


