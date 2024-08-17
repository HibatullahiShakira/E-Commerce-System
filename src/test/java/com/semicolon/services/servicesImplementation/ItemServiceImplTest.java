package com.semicolon.services.servicesImplementation;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.Product;
import com.semicolon.data.repositories.ItemRepository;
import com.semicolon.dto.request.DeleteItemRequest;
import com.semicolon.dto.request.ItemDtoRequest;
import com.semicolon.dto.request.ItemUpdateRequest;
import com.semicolon.dto.response.AddItemResponse;
import com.semicolon.dto.response.ItemUpdateResponse;
import com.semicolon.services.serviceInterface.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.semicolon.data.model.ProductCategory.ELECTRONICS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemServiceImplTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;
    @BeforeEach
    void setUp() {
        itemRepository.deleteAll();
    }

    @Test
    public void testAddItem() {
        Product product = new Product();
        product.setProductName("keyboard");
        product.setProductCategory(ELECTRONICS);
        product.setPrice(5000);
        product.setProductDescription("This is used for typing on the monitor");
        ItemDtoRequest itemDtoRequest = new ItemDtoRequest();
        itemDtoRequest.setQuantity(10);
        itemDtoRequest.setProduct(product);

        AddItemResponse addItemResponse = itemService.addItem(itemDtoRequest);
        assertEquals(addItemResponse.getMessage(), "Successfully added item");
        assertEquals(addItemResponse.getSubTotal(), 50000);
    }

    @Test
    public void testUpdateItem() {
        Product product = new Product();
        product.setProductName("keyboard");
        product.setProductCategory(ELECTRONICS);
        product.setPrice(5000);
        product.setProductDescription("This is used for typing on the monitor");
        ItemDtoRequest itemDtoRequest = new ItemDtoRequest();
        itemDtoRequest.setQuantity(10);
        itemDtoRequest.setProduct(product);
        itemService.addItem(itemDtoRequest);

        AddItemResponse addItemResponse = itemService.addItem(itemDtoRequest);

        ItemUpdateRequest itemUpdateRequest = new ItemUpdateRequest();
        itemUpdateRequest.setQuantity(5);
        itemUpdateRequest.setProduct(product);
        itemUpdateRequest.setItemId(addItemResponse.getItemId());

        ItemUpdateResponse itemUpdateResponse = itemService.updateItemById(itemUpdateRequest);
        assertEquals(itemUpdateResponse.getMessage(), "Successfully updated item");
        assertEquals(itemUpdateResponse.getSubtotal(), 25000);
    }

    @Test
    public void testRemoveItem() {
        Product product = new Product();
        product.setProductName("keyboard");
        product.setProductCategory(ELECTRONICS);
        product.setPrice(5000);
        product.setProductDescription("This is used for typing on the monitor");
        ItemDtoRequest itemDtoRequest = new ItemDtoRequest();
        itemDtoRequest.setQuantity(10);
        itemDtoRequest.setProduct(product);
        itemService.addItem(itemDtoRequest);

        AddItemResponse addItemResponse = itemService.addItem(itemDtoRequest);
        DeleteItemRequest deleteItemRequest = new DeleteItemRequest();
        deleteItemRequest.setItemId(addItemResponse.getItemId());
        String response = itemService.removeItem(deleteItemRequest);
        assertEquals(response, "Successfully removed item");
    }

    @Test
    public void testFindAllItems() {
        Product product = new Product();
        product.setProductName("keyboard");
        product.setProductCategory(ELECTRONICS);
        product.setPrice(5000);
        product.setProductDescription("This is used for typing on the monitor");
        ItemDtoRequest itemDtoRequest = new ItemDtoRequest();
        itemDtoRequest.setQuantity(10);
        itemDtoRequest.setProduct(product);
        itemService.addItem(itemDtoRequest);

        List<Item> products = itemService.getAllItem();
        assertEquals(products.size(), 1);
    }

}
