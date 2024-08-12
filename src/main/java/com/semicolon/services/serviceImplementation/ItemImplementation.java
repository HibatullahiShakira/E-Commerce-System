package com.semicolon.services.serviceImplementation;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.Product;
import com.semicolon.dto.request.DeleteItemRequest;
import com.semicolon.dto.request.ItemDtoRequest;
import com.semicolon.dto.request.ItemUpdateRequest;
import com.semicolon.dto.response.AddItemResponse;
import com.semicolon.dto.response.ItemDtoResponse;
import com.semicolon.dto.response.ItemUpdateResponse;
import com.semicolon.repositories.ItemRepository;
import com.semicolon.services.serviceInterface.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemImplementation implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemImplementation(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public AddItemResponse addItem(ItemDtoRequest itemDtoRequest) {
        Item item = new Item();
        item.setProduct(itemDtoRequest.getProduct());
        item.setQuantity(itemDtoRequest.getQuantity());
        item.setItemId(itemDtoRequest.getItemId());
        BigDecimal price = itemDtoRequest.getProduct().getPrice();
        BigDecimal subTotal = price.multiply(new BigDecimal(itemDtoRequest.getQuantity()));
        item.setSubTotal(subTotal);
        itemRepository.save(item);

        AddItemResponse addItemResponse = new AddItemResponse();
        addItemResponse.setItemId(item.getItemId());
        addItemResponse.setSubTotal(item.getSubTotal());
        addItemResponse.setMessage("Successfully added item");
        return addItemResponse;
    }

    @Override
    public ItemUpdateResponse updateItemById(ItemUpdateRequest itemUpdateRequest) {
        Item item = itemRepository.findById(itemUpdateRequest.getItemId()).orElse(null);
        if (item != null) {
            if (itemUpdateRequest.getQuantity() != item.getQuantity() || itemUpdateRequest.getProduct() != null) {
                item.setQuantity(itemUpdateRequest.getQuantity());
                item.setProduct(item.getProduct());
                BigDecimal productPrice = item.getProduct().getPrice();
                BigDecimal subTotal = productPrice.multiply(new BigDecimal(itemUpdateRequest.getQuantity()));
                item.setSubTotal(subTotal);
            }
        }else {
            throw new NullPointerException("Item not found");
        }
        itemRepository.save(item);
        ItemUpdateResponse itemUpdateResponse = new ItemUpdateResponse();
        itemUpdateResponse.setSubtotal(item.getSubTotal());
        itemUpdateResponse.setMessage("Successfully updated item");
        return itemUpdateResponse;
        }

    @Override
    public String removeItem(DeleteItemRequest deleteItemRequest) {
        Item item = itemRepository.findById(deleteItemRequest.getItemId()).orElse(null);
        if (item == null) {
            throw new NullPointerException("Item not found");
        }else {
            itemRepository.delete(item);
        }
        return "Successfully removed item";
    }

    @Override
    public ItemDtoResponse getItemById(ItemDtoRequest itemDtoRequest) {
        Item item = itemRepository.findById(itemDtoRequest.getItemId()).orElse(null);
        if (item == null) {
            throw new NullPointerException("Item not found");
        }
        Product product = new Product();
        ItemDtoResponse itemDtoResponse = new ItemDtoResponse();
        itemDtoResponse.setQuantity(item.getQuantity());
        itemDtoResponse.setProduct(item.getProduct());
        itemDtoResponse.setItemId(item.getItemId());
        BigDecimal subTotal = product.getPrice().multiply(new BigDecimal(itemDtoRequest.getQuantity()));
        itemDtoResponse.setSubTotal(subTotal);
        return itemDtoResponse;
    }



}
