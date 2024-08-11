package com.semicolon.services.serviceInterface;

import com.semicolon.data.model.Product;
import com.semicolon.dto.request.DeleteProductRequest;
import com.semicolon.dto.request.ProductDtoRequest;
import com.semicolon.dto.request.ProductUpdateRequest;
import com.semicolon.dto.response.AddProductResponse;
import com.semicolon.dto.response.ProductDtoResponse;
import com.semicolon.dto.response.ProductUpdateResponse;

import java.util.List;

public interface ShoppingCartItem {
    List<Product> getAllProduct();
    AddProductResponse addProduct(ProductDtoRequest productDtoRequest);
    ProductUpdateResponse updateProductById(ProductUpdateRequest productUpdateRequest);
    String deleteProduct(DeleteProductRequest productRequest);
    ProductDtoResponse getProductById(ProductDtoRequest productDtoRequest);
}
