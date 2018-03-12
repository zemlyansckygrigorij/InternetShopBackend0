package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService{
    @Autowired
    private ProductRepository productRepo;

    public List<Product> productList (){
        return (List<Product>) productRepo.findAll();
    }

    public List<Product> updateProducts(List<Product> productList){
        productList.stream().forEach((p)->{
            productRepo.findById((int) p.getId()).ifPresent((product)-> product.reduceAmount(p.getAmount()));
        });
        return (List<Product>) productRepo.findAll();
    }

}
