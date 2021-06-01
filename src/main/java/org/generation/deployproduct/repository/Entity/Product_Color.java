package org.generation.deployproduct.repository.Entity;

import org.generation.deployproduct.controller.DTO.ProductColorDTO;

public class Product_Color {

    private int Product_Product_code;
    private String color;

    public Product_Color() {}

    public Product_Color(ProductColorDTO productColorDTO) {
        this.color = productColorDTO.getColor();
    }

    public int getProduct_Product_code() { return this.Product_Product_code; }
    public void setProduct_Product_code(int product_Product_code) { this.Product_Product_code = product_Product_code; }

    public String getColor() { return this.color; }
    public void setColor(String color) { this.color = color; }


    @Override
    public String toString() {
        return String.format("ProductColor{Product_Product_code='%d', color='%s'", this.Product_Product_code, this.color);
    }

}
