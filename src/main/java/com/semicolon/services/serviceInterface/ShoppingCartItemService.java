package com.semicolon.services.serviceInterface;

import com.semicolon.data.model.ShoppingCartItem;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;

import java.util.List;

public interface ShoppingCartItemService {
    List<ShoppingCartItem> getAllShoppingCartItem();
    AddShoppingCartItemResponse addShoppingCartItem(ShoppingCartItemDtoRequest shoppingCartItemDtoRequest);
    ShoppingCartItemUpdateResponse updateShoppingCartItemByUser(ShoppingCartItemUpdateRequest shoppingCartItemUpdateRequest);
    String deleteShoppingCartItemByUser(DeleteShoppingCartItemRequest shoppingCartItemRequest);
    ShoppingCartItemUpdateResponse updateShoppingCartItemById(ShoppingCartItemUpdateRequest shoppingCartItemDtoRequest);
    ShoppingCartItemDtoResponse getShoppingCartItemByUser(GetShoppingCartItemDtoRequest shoppingCartItemGetRequest);
    ShoppingCartItemDtoResponse getShoppingCartItemById(GetShoppingCartItemDtoRequest shoppingCartItemGetRequest);

}
