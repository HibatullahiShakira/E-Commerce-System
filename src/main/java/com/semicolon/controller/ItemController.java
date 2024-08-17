package com.semicolon.controller;

import com.semicolon.data.model.Item;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;
import com.semicolon.services.serviceInterface.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/item-api")
@Service
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("items")
    public ResponseEntity<List<Item>> getAllItem() {
        return new ResponseEntity<>(itemService.getAllItem(), HttpStatus.OK);
    }

    @GetMapping("item")
    public ResponseEntity<ItemDtoResponse> getItem(@RequestBody ItemDtoRequest itemDtoRequest) {
        return ResponseEntity.ok(itemService.getItemById(itemDtoRequest));
    }

    @PostMapping("item/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddItemResponse> createItem(@RequestBody ItemDtoRequest ItemDtoRequest) {
        return ResponseEntity.ok(itemService.addItem(ItemDtoRequest));
    }

    @PatchMapping("item/update")
    public ResponseEntity<ItemUpdateResponse> updateItem(@RequestBody ItemUpdateRequest ItemUpdateRequest) {
        ItemUpdateResponse response = itemService.updateItemById(ItemUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("item/delete")
    public ResponseEntity<String> deleteItem(@RequestBody DeleteItemRequest deleteItemRequest) {
        itemService.removeItem(deleteItemRequest);
        return new ResponseEntity<>("Item removed", HttpStatus.OK);
    }

}
