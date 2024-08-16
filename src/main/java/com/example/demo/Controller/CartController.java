//package com.example.demo.Controller;
//
//import com.example.demo.Service.ProductService;
//import com.example.demo.entity.CartItem;
//import com.example.demo.entity.Product;
//import com.example.demo.request.CartRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/cart")
//@CrossOrigin(origins = "https://landingpage2424.netlify.app")
//public class CartController {
//
//
//    private ProductService productService;
//
//    public CartController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CartItem>> getCart() {
//        List<CartItem> cartItemProducts = productService.getCart();
//
//        return new ResponseEntity<>(cartItemProducts, HttpStatus.OK);
//    }
//    @PostMapping
//    public ResponseEntity<List<CartItem>> addToCart(
//            @RequestBody CartRequest cartRequest
//            ) throws Exception {
//        List<CartItem> cartItemProducts = productService.addToCart(cartRequest.getId(), cartRequest.getQuantity());
//
//        return new ResponseEntity<>(cartItemProducts, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{productId}")
//    public ResponseEntity<String> removeItemFromCart(@PathVariable int productId) throws Exception {
//        productService.removeItemFromCartByProductId(productId);
//        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
//    }
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<String> handleExecption(Exception exception){
//        return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
//    }
//}
package com.example.demo.Controller;

import com.example.demo.Service.ProductService;
import com.example.demo.entity.CartItem;
import com.example.demo.request.CartRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCart() {
        List<CartItem> cartItemProducts = productService.getCart();
        return new ResponseEntity<>(cartItemProducts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<CartItem>> addToCart(@RequestBody CartRequest cartRequest) throws Exception {
        List<CartItem> cartItemProducts = productService.addToCart(cartRequest.getId(), cartRequest.getQuantity());
        return new ResponseEntity<>(cartItemProducts, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable int productId) throws Exception {
        productService.removeItemFromCartByProductId(productId);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleException(Exception exception) {
        return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
    }
}
