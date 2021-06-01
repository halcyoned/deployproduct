package org.generation.deployproduct.controller.DTO;


public class productColorDTO {

    private int Product_Product_code;
    private String color;

    public productColorDTO(int Product_Product_code, String color)
    {
        this.productCode = Product_Product_code;
        this.color = color;

    public String getProductCode() {return Product_Product_code;}

    public void setProductCode(String ) {this.productCode = Product_Product_code; }

    public String getColor() {return color; }

    public void setColor(String color) {this.color = color;}
}

