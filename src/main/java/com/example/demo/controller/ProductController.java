package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin
@Configuration
@RestController
@RequestMapping("/")
public class ProductController{
    /**
     *
     */


//1)
//    @Autowired
//    private ProductRepository productRepo;

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<Collection<Product>> getProducts() {
//            return new ResponseEntity<Collection<Product>>(productRepo.findAll(), HttpStatus.OK);
//    }


//  2)
    @Autowired
    ProductService productService;

        @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> productList=productService.productList();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }


//3)
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getProduct() {
//        return new ResponseEntity("ok", HttpStatus.OK);
//    }




    @PutMapping("/")
    public ResponseEntity<List<Product>> Products ( @RequestBody List<Product> updateList){

        productService.updateProducts(updateList);

        List<Product> productList = productService.productList();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

}

