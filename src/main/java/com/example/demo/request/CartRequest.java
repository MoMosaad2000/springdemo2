package com.example.demo.request;

public class CartRequest {
    private int id;
    private int quantity;

    public CartRequest(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public CartRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
