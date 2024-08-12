package com.semicolon.controller;

import com.semicolon.data.model.Product;
import com.semicolon.data.model.UserRole;
import com.semicolon.dto.request.DeleteProductRequest;
import com.semicolon.dto.request.ProductDtoRequest;
import com.semicolon.dto.request.ProductUpdateRequest;
import com.semicolon.dto.response.AddProductResponse;
import com.semicolon.dto.response.ProductDtoResponse;
import com.semicolon.dto.response.ProductUpdateResponse;
import com.semicolon.services.serviceInterface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.semicolon.data.model.UserRole.SELLERS;

@RestController
@RequestMapping("/product-api/")
@Service
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("product")
    public ResponseEntity<ProductDtoResponse> getProduct(@RequestBody ProductDtoRequest productDtoRequest) {
        return ResponseEntity.ok(productService.getProduct());
    }

    @PostMapping("product/createBySellers")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddProductResponse> createProduct(@RequestBody ProductDtoRequest productDtoRequest) {
        return ResponseEntity.ok(productService.addProductBySellers(productDtoRequest));
    }

    @PutMapping("product/updateBySellers")
    public ResponseEntity<ProductUpdateResponse> updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest) {
        ProductUpdateResponse response = productService.updateProductBySellers(productUpdateRequest, SELLERS );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("product/deleteBySellers")
    public ResponseEntity<String> deleteProduct(@RequestBody DeleteProductRequest deleteProductRequest) {
        productService.deleteProductSeller(deleteProductRequest);
        return new ResponseEntity<>("Contact deleted sucessfully", HttpStatus.OK);
    }

    @GetMapping("product_by_name")
    public ResponseEntity<List<ProductDtoResponse>> getProductName(@RequestBody ProductDtoRequest productDtoRequest) {
        return new ResponseEntity<>(productService.getProductByName(productDtoRequest), HttpStatus.OK);
    }

}
