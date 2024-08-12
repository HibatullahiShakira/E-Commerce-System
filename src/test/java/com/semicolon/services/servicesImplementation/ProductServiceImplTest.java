package com.semicolon.services.servicesImplementation;

import com.semicolon.data.model.Product;
import com.semicolon.data.model.UserRole;
import com.semicolon.dto.request.DeleteProductRequest;
import com.semicolon.dto.request.ProductDtoRequest;
import com.semicolon.dto.request.ProductUpdateRequest;
import com.semicolon.dto.response.AddProductResponse;
import com.semicolon.dto.response.ProductUpdateResponse;
import com.semicolon.repositories.ProductRepository;
import com.semicolon.services.serviceInterface.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static com.semicolon.data.model.ProductCategory.ELECTRONICS;
import static com.semicolon.data.model.ProductCategory.STATIONARIES;
import static com.semicolon.data.model.UserRole.SELLERS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;
    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    public void testAddProduct() {
        ProductDtoRequest productRequest = new ProductDtoRequest();
        productRequest.setProductName("Book");
        productRequest.setProductDescription("Use for writing things down");
        productRequest.setProductCategory(STATIONARIES);
        productRequest.setUserRole(SELLERS);
        productRequest.setProductPrice(new BigDecimal("7809089"));

        AddProductResponse addProductResponse = productService.addProductBySellers(productRequest);
        //System.out.println(addProductResponse.getId());
        assertEquals(addProductResponse.getMessage(), "Product created successfully");
    }

    @Test
    public void testUpdateProduct() {
        ProductDtoRequest productRequest = new ProductDtoRequest();
        productRequest.setProductName("Book");
        productRequest.setProductDescription("Use for writing things down");
        productRequest.setProductCategory(STATIONARIES);
        productRequest.setProductPrice(new BigDecimal("9809089"));
        AddProductResponse addProductResponse = productService.addProductBySellers(productRequest);

        ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
        productUpdateRequest.setProductName("Iron");
        productUpdateRequest.setProductDescription("Use for ironing cloth");
        productUpdateRequest.setProductCategory(ELECTRONICS);
        productUpdateRequest.setId(addProductResponse.getProductId());
        ProductUpdateResponse productUpdateResponse  = productService.updateProductBySellers(productUpdateRequest, SELLERS );
        assertEquals(productUpdateResponse.getMessage(), "Product updated successfully");



    }

    @Test
    public void testDeleteProduct() {
        ProductDtoRequest productRequest = new ProductDtoRequest();
        productRequest.setProductName("Book");
        productRequest.setProductDescription("Use for writing things down");
        productRequest.setUserRole(SELLERS);
        productRequest.setProductCategory(STATIONARIES);

        AddProductResponse addProductResponse = productService.addProductBySellers(productRequest);
        DeleteProductRequest deleteProductRequest = new DeleteProductRequest();
        deleteProductRequest.setProduct_id(addProductResponse.getProductId());
        deleteProductRequest.setUserRole(SELLERS);
        String response = productService.deleteProductSeller(deleteProductRequest);
        assertEquals(response, "Product deleted successfully");
    }

    @Test
    public void testFindAllContacts() {
        ProductDtoRequest productRequest = new ProductDtoRequest();
        productRequest.setProductName("Book");
        productRequest.setProductDescription("Use for writing things down");
        productRequest.setProductCategory(STATIONARIES);

        AddProductResponse addProductResponse = productService.addProductBySellers(productRequest);
        List<Product> products = productService.getAllProduct();
        assertEquals(products.size(), 1);
    }

}
