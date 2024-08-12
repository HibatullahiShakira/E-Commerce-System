package com.semicolon.services.serviceInterface;

import com.semicolon.data.model.Product;
import com.semicolon.data.model.UserRole;
import com.semicolon.dto.request.DeleteProductRequest;
import com.semicolon.dto.request.ProductDtoRequest;
import com.semicolon.dto.request.ProductUpdateRequest;
import com.semicolon.dto.response.AddProductResponse;
import com.semicolon.dto.response.ProductDtoResponse;
import com.semicolon.dto.response.ProductUpdateResponse;

import java.util.List;

public interface ProductService {
    List<ProductDtoResponse> getProductByName(ProductDtoRequest productDtoRequest);
    List<Product> getAllProduct();
    AddProductResponse addProductBySellers(ProductDtoRequest productDtoRequest);
    ProductUpdateResponse updateProductBySellers(ProductUpdateRequest productUpdateRequest, UserRole userRole);
    String deleteProductSeller(DeleteProductRequest productRequest);
    ProductDtoResponse getProduct();

}
