package com.semicolon.services.serviceImplementation;

import com.semicolon.data.model.Product;
import com.semicolon.data.model.UserRole;
import com.semicolon.data.repositories.ProductRepository;
import com.semicolon.dto.request.DeleteProductRequest;
import com.semicolon.dto.request.ProductDtoRequest;
import com.semicolon.dto.request.ProductUpdateRequest;
import com.semicolon.dto.response.AddProductResponse;
import com.semicolon.dto.response.ProductDtoResponse;
import com.semicolon.dto.response.ProductUpdateResponse;
import com.semicolon.services.serviceInterface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.semicolon.data.model.UserRole.SELLERS;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDtoResponse> getProductByName(ProductDtoRequest productDtoRequest) {
        List<ProductDtoResponse> matchingProduct = new ArrayList<>();
        List<Product> foundProducts = productRepository.findProductByProductName(productDtoRequest.getProductName());
        if (foundProducts == null) {
            throw new NullPointerException("Product not found");
        }
        for (Product product : foundProducts) {
            ProductDtoResponse foundProductDto = new ProductDtoResponse();
            foundProductDto.setId(product.getId());
            foundProductDto.setProductName(product.getProductName());
            foundProductDto.setProductPrice(product.getPrice());
            foundProductDto.setProductDescription(product.getProductDescription());
            foundProductDto.setProductCategory(product.getProductCategory());
            foundProductDto.setProductImage(productDtoRequest.getProductImage());
            matchingProduct.add(foundProductDto);

        }
        return matchingProduct;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        if (products == null) {
            throw new NullPointerException("List of Product not found");
        }
        return products;
    }

    @Override
    public AddProductResponse addProductBySellers(ProductDtoRequest productDtoRequest) {
        Product product = new Product();
        product.setUserRole(productDtoRequest.getUserRole());
        product.setProductName(productDtoRequest.getProductName());
        product.setProductDescription(productDtoRequest.getProductDescription());
        product.setProductCategory(productDtoRequest.getProductCategory());
        product.setPrice(productDtoRequest.getProductPrice());
        product.setImage(productDtoRequest.getProductImage());
        productRepository.save(product);
        AddProductResponse productResponse = new AddProductResponse();
        productResponse.setProductId(product.getId());
        productResponse.setPrice(product.getPrice());
        productResponse.setProductName(product.getProductName());

        productResponse.setMessage("Product created successfully");
        return productResponse;
    }

    @Override
    public ProductUpdateResponse updateProductBySellers(ProductUpdateRequest productUpdateRequest, UserRole userRole) {
        if (userRole == SELLERS) {
            Product foundProduct = productRepository.findById(productUpdateRequest.getId()).orElse(null);
            ProductUpdateResponse productUpdateResponse = new ProductUpdateResponse();
            if (foundProduct == null) {
                throw new NullPointerException("Product not found");
            } else {
                if (productUpdateRequest.getProductName() != null) {
                    foundProduct.setProductName(productUpdateRequest.getProductName());
                }
                if (productUpdateRequest.getProductDescription() != null) {
                    foundProduct.setProductDescription(productUpdateRequest.getProductDescription());
                }
                if (productUpdateRequest.getProductCategory() != null) {
                    foundProduct.setProductCategory(productUpdateRequest.getProductCategory());
                }
                if (productUpdateRequest.getProductPrice() != productUpdateRequest.getProductPrice()) {
                    foundProduct.setPrice(productUpdateRequest.getProductPrice());
                }
                if(productUpdateRequest.getProductImage() != null) {
                    foundProduct.setImage(productUpdateRequest.getProductImage());
                }
                productRepository.save(foundProduct);
                productUpdateResponse.setMessage("Product updated successfully");
                return productUpdateResponse;
            }
        }
        throw new NullPointerException("User not authorized to update this product");

    }

    @Override
    public String deleteProductSeller(DeleteProductRequest deleteProductRequest) {
        if (deleteProductRequest.getUserRole() == SELLERS) {
            Product foundProduct = productRepository.findById(deleteProductRequest.getProduct_id()).orElse(null);
            if (foundProduct == null) {
                throw new NullPointerException("Product not found");
            } else {
                productRepository.delete(foundProduct);
            }
            return "Product deleted successfully";
        }
        throw new NullPointerException("User not authorized to delete this product");
    }


}
