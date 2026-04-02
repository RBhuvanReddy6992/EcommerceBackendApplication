package com.ecommerce.Cart_Service.Model;


public class ProductDTO {

    private Integer product_id;
    private String name;
    private String category_id;
    private double price;
    private Integer quantity;

    // Getters and Setters
    public Integer getProduct_id() { return product_id; }
    public void setProduct_id(Integer product_id) { this.product_id = product_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory_id() { return category_id; }
    public void setCategory_id(String category_id) { this.category_id = category_id; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
