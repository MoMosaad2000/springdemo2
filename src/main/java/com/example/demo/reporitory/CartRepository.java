package com.example.demo.reporitory;

import com.example.demo.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByProductId(int productId);
}
