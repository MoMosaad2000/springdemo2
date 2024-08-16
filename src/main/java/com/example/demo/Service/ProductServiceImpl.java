package com.example.demo.Service;

import com.example.demo.entity.CartItem;
import com.example.demo.entity.Product;
import com.example.demo.reporitory.CartRepository;
import com.example.demo.reporitory.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    private CartRepository cartRepository;

    public ProductServiceImpl(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public Product getProductById(int id) throws Exception{
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()) throw new Exception("Couldn't Find Product with id " + id);
        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) throws Exception {
        Product foundProduct= getProductById(id);

        if(product.getImg() != null) foundProduct.setImg(product.getImg());
        if(product.getUpdatedAt() != null) foundProduct.setUpdatedAt(product.getUpdatedAt());
        if(product.getTitle() != null) foundProduct.setTitle(product.getTitle());
        if(product.getCreatedAt() != null) foundProduct.setCreatedAt(product.getCreatedAt());
        if(product.getPrice() != 0.0) foundProduct.setPrice(product.getPrice());

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(int id) throws Exception {
        Product foundProduct= getProductById(id);

        productRepository.delete(foundProduct);
    }

    @Override
    public List<CartItem> getCart() {

        return cartRepository.findAll();
    }

    @Override
    public List<CartItem> addToCart(int productId, int quantity) throws Exception {
        System.out.println(productId + " " + quantity);
        Product foundProduct= getProductById(productId);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(foundProduct);
        cartItem.setCreatedAt(new Date());
        cartItem.setUpdatedAt(new Date());
        cartItem.setQuantity(quantity);
        cartRepository.save(cartItem);
        return cartRepository.findAll();
    }

    @Override
    public List<CartItem> getItemsByProductId(int productId) throws Exception {
        return cartRepository.findByProductId(productId);
    }

    @Override
    public void removeItemFromCartByProductId(int productId) throws Exception {
        List<CartItem> cartItem = getItemsByProductId(productId);

        cartRepository.deleteAll(cartItem);
    }
}
