package com.example.demo.Service;

import com.example.demo.entity.CartItem;
import com.example.demo.entity.Product;

import java.util.List;


public interface ProductService {

    Product getProductById(int id) throws Exception;

    Product createProduct(Product product);

    Product updateProduct(int id, Product product) throws Exception;

    List<Product> getAllProducts();

    void deleteProduct(int id) throws Exception;

    List<CartItem> getCart();

    List<CartItem> addToCart(int productId, int quantity) throws Exception;


    List<CartItem> getItemsByProductId(int productId) throws Exception;

    void removeItemFromCartByProductId(int productId) throws Exception;


}
