package com.example.demo.Controller;

import com.example.demo.Service.ProductService;
import com.example.demo.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "https://66bfb07b9a4e0da54aaa6970--papaya-crumble-595094.netlify.app")
public class productController {

    private ProductService productService;

    public productController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = productService.getAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) throws Exception {

        Product product = productService.getProductById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws Exception {

        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, Product product) throws Exception {


        return new ResponseEntity<>(productService.updateProduct(id,product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id, Product product) throws Exception {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleExecption(Exception exception){
        return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }


}