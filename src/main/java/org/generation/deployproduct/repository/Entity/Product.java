package org.generation.deployproduct.repository.Entity;

public class Product {

    private Integer Product_code;
    private String name;
    private String description;
    private String image_url;
    private String category;
    private double price;

    public Product() {}

//    public Product(ProductDTO productDTO) {
//        this.name = productDTO.getName();
//        this.description = productDTO.getDescription();
//        this.image_url = productDTO.getImageUrl();
//        this.category = productDTO.getCategory();
//        this.price = productDTO.getPrice();
//    }

    public Integer getProduct_code() { return this.Product_code; }
    public void setProduct_code(Integer product_code) { this.Product_code = product_code; }

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
        return String.format("Product!{Product_code='%d', name='%s', description='%s', image_url='%s', category='%s', price='%.2f'",
                this.Product_code, this.name, this.description, this.image_url, this.category, this.price);
    }

}
