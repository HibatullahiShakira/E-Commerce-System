package com.semicolon.controller;

import com.semicolon.data.model.ShoppingCartItem;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;
import com.semicolon.services.serviceInterface.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/shoppingCartItem-api/")
public class ShoppingCartItemController {
    private final ShoppingCartItemService shoppingCartItemService;

    @Autowired
    public ShoppingCartItemController(ShoppingCartItemService shoppingCartItemService) {
        this.shoppingCartItemService = shoppingCartItemService;
    }

    @GetMapping("shoppingCartItems")
    public ResponseEntity<List<ShoppingCartItem>> getAllShoppingCartItem() {
        return new ResponseEntity<>(shoppingCartItemService.getAllShoppingCartItem(), HttpStatus.OK);
    }

    @GetMapping("shoppingCartItem/shopping-cart-id")
    public ResponseEntity<ShoppingCartItemDtoResponse> getShoppingCartByShoppingCartId(@RequestBody GetShoppingCartItemDtoRequest getShoppingCartItemDtoRequest) {
        return ResponseEntity.ok(shoppingCartItemService.getShoppingCartItemById(getShoppingCartItemDtoRequest));
    }

    @GetMapping("shoppingCartItem/shopping-user")
    public ResponseEntity<ShoppingCartItemDtoResponse> getShoppingCartByUser(@RequestBody GetShoppingCartItemDtoRequest getShoppingCartItemDtoRequest) {
        return ResponseEntity.ok(shoppingCartItemService.getShoppingCartItemByUser(getShoppingCartItemDtoRequest));
    }

    @PostMapping("shoppingCartItem/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddShoppingCartItemResponse> createShoppingCartItem(@RequestBody ShoppingCartItemDtoRequest shoppingCartItemDtoRequest) {
        return ResponseEntity.ok(shoppingCartItemService.addShoppingCartItem(shoppingCartItemDtoRequest));
    }

    @PatchMapping("shoppingCartItem/updateByShoppingCartId")
    public ResponseEntity<ShoppingCartItemUpdateResponse> updateShoppingCartItemById(@RequestBody ShoppingCartItemUpdateRequest shoppingCartItemUpdateRequest) {
        ShoppingCartItemUpdateResponse response = shoppingCartItemService.updateShoppingCartItemById(shoppingCartItemUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("shoppingCartItem/updateByUser")
    public ResponseEntity<ShoppingCartItemUpdateResponse> updateShoppingCartItemByUser(@RequestBody ShoppingCartItemUpdateRequest shoppingCartItemUpdateRequest) {
        ShoppingCartItemUpdateResponse response = shoppingCartItemService.updateShoppingCartItemById(shoppingCartItemUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("shoppingCartItem/delete")
    public ResponseEntity<String> deleteShoppingCartItem(@RequestBody DeleteShoppingCartItemRequest deleteShoppingCartItemRequest) {
        shoppingCartItemService.deleteShoppingCartItemByUser(deleteShoppingCartItemRequest);
        return new ResponseEntity<>("Shopping Cart deleted sucessfully", HttpStatus.OK);
    }
}
