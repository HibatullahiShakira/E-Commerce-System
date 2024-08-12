package com.semicolon.services.serviceInterface;

import com.semicolon.data.model.Item;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;


import java.math.BigDecimal;
import java.util.List;

public interface ItemService {
    List<Item> getAllItem();
    AddItemResponse addItem(ItemDtoRequest itemDtoRequest);
    ItemUpdateResponse updateItemById(ItemUpdateRequest itemUpdateRequest);
    String removeItem(DeleteItemRequest itemRequest);
    ItemDtoResponse getItemById(ItemDtoRequest itemDtoRequest);
}
