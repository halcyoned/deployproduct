package org.generation.deployproduct.controller.DTO;


public class ProductColorDTO {

    private int Product_Product_code;
    private String color;

    public ProductColorDTO(int product_Product_code, String color) {
        this.Product_Product_code = product_Product_code;
        this.color = color;
    }

    public int getProduct_Product_code() { return this.Product_Product_code; }
    public void setProduct_Product_code(int product_Product_code) { this.Product_Product_code = product_Product_code; }

    public String getColor() { return this.color; }
    public void setColor(String color) { this.color = color;}

}

