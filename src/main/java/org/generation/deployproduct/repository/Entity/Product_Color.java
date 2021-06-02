package org.generation.deployproduct.repository.Entity;

import org.generation.deployproduct.controller.DTO.ProductColorDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product_Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Product_Color_id;
    private int Product_Product_code;
    private String color;

    public Product_Color() {}

    public Product_Color(ProductColorDTO productColorDTO) {
        this.Product_Product_code = productColorDTO.getProduct_Product_code();
        this.color = productColorDTO.getColor();
    }

    public int getProduct_Color_id() { return this.Product_Color_id; }
    public void setProduct_Color_id(int product_Color_id) { this.Product_Color_id = product_Color_id; }

    public int getProduct_Product_code() { return this.Product_Product_code; }
    public void setProduct_Product_code(int product_Product_code) { this.Product_Product_code = product_Product_code; }

    public String getColor() { return this.color; }
    public void setColor(String color) { this.color = color; }


    @Override
    public String toString() {
        return String.format("ProductColor{Product_Color_id='%d', Product_Product_code='%d', color='%s'",
                this.Product_Color_id, this.Product_Product_code, this.color);
    }

}
