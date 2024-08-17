package com.semicolon.services.serviceImplementation;

import com.semicolon.data.model.Item;
import com.semicolon.data.model.OrderStatus;
import com.semicolon.data.model.ShoppingCartItem;
import com.semicolon.data.repositories.ShoppingCartRepository;
import com.semicolon.dto.request.DeleteShoppingCartItemRequest;
import com.semicolon.dto.request.GetShoppingCartItemDtoRequest;
import com.semicolon.dto.request.ShoppingCartItemDtoRequest;
import com.semicolon.dto.request.ShoppingCartItemUpdateRequest;
import com.semicolon.dto.response.AddShoppingCartItemResponse;
import com.semicolon.dto.response.ShoppingCartItemDtoResponse;
import com.semicolon.dto.response.ShoppingCartItemUpdateResponse;
import com.semicolon.services.serviceInterface.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.semicolon.data.model.OrderStatus.PENDING;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartItemServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public List<ShoppingCartItem> getAllShoppingCartItem() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public AddShoppingCartItemResponse addShoppingCartItem(ShoppingCartItemDtoRequest shoppingCartItemDtoRequest) {
        double subTotal = 0;
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setCreationDate(LocalDateTime.now());
        shoppingCartItem.setItems(shoppingCartItemDtoRequest.getItems());
        shoppingCartItem.setTaxRate(shoppingCartItemDtoRequest.getTax());
        shoppingCartItem.setStatus(shoppingCartItemDtoRequest.getStatus());
        shoppingCartItem.setUser(shoppingCartItem.getUser());
        shoppingCartItem.setUserId(shoppingCartItemDtoRequest.getUser().getUserId());
        for (Item item : shoppingCartItemDtoRequest.getItems()) {
            subTotal += item.getSubTotal();
        }
        double taxRateDecimal = shoppingCartItemDtoRequest.getTax() / 100;
        double taxAmount = subTotal * taxRateDecimal;
        double subTotalAmount = subTotal + taxAmount;
        shoppingCartItem.setTotalPrice(subTotalAmount);
        shoppingCartRepository.save(shoppingCartItem);

        AddShoppingCartItemResponse addShoppingCartItemResponse = new AddShoppingCartItemResponse();
        addShoppingCartItemResponse.setCreationDate(LocalDateTime.now());
        addShoppingCartItemResponse.setStatus(PENDING);
        addShoppingCartItemResponse.setShoppingCartId(shoppingCartItem.getShoppingCartId());
        addShoppingCartItemResponse.setTotalPrice(shoppingCartItem.getTotalPrice());
        addShoppingCartItemResponse.setMessage("Shopping cart added successfully");
        return addShoppingCartItemResponse;
    }

    @Override
    public ShoppingCartItemUpdateResponse updateShoppingCartItemByUser(ShoppingCartItemUpdateRequest shoppingCartItemUpdateRequest) {
        ShoppingCartItem shoppingCartItem = shoppingCartRepository.findByUser(shoppingCartItemUpdateRequest.getUser());
        return getShoppingCartItemUpdateResponse(shoppingCartItemUpdateRequest, shoppingCartItem);
    }

    @Override
    public String deleteShoppingCartItemByUser(DeleteShoppingCartItemRequest deleteShoppingCartItemRequest) {
        ShoppingCartItem shoppingCartItem = shoppingCartRepository.findByUser(deleteShoppingCartItemRequest.getUser());
        if (shoppingCartItem == null) {
            throw new NullPointerException("Shopping Cart Item not found");
        }else {
            shoppingCartRepository.delete(shoppingCartItem);
        }
        return "Shopping Cart Item Deleted";
    }

    @Override
    public ShoppingCartItemUpdateResponse updateShoppingCartItemById(ShoppingCartItemUpdateRequest shoppingCartItemDtoRequest) {
        ShoppingCartItem shoppingCartItem = shoppingCartRepository.findById(shoppingCartItemDtoRequest.getId()).orElse(null);
        return getShoppingCartItemUpdateResponse(shoppingCartItemDtoRequest, shoppingCartItem);
    }

    @Override
    public ShoppingCartItemDtoResponse getShoppingCartItemByUser(GetShoppingCartItemDtoRequest shoppingCartItemGetRequest) {
        ShoppingCartItem shoppingCartItem = shoppingCartRepository.findByUser(shoppingCartItemGetRequest.getUser());
        return getShoppingCartItemDtoResponse(shoppingCartItem);
    }

    private ShoppingCartItemDtoResponse getShoppingCartItemDtoResponse(ShoppingCartItem shoppingCartItem) {
        ShoppingCartItemDtoResponse shoppingCartItemDtoResponse = new ShoppingCartItemDtoResponse();
        shoppingCartItemDtoResponse.setCreationDate(LocalDateTime.now());
        shoppingCartItemDtoResponse.setItems(shoppingCartItem.getItems());
        shoppingCartItemDtoResponse.setTaxRate(shoppingCartItem.getTaxRate());
        shoppingCartItemDtoResponse.setStatus(shoppingCartItem.getStatus());
        shoppingCartItemDtoResponse.setUser(shoppingCartItem.getUser());
        shoppingCartItemDtoResponse.setUserId(shoppingCartItem.getUser().getUserId());
        shoppingCartItemDtoResponse.setTotalPrice(shoppingCartItem.getTotalPrice());
        shoppingCartItemDtoResponse.setShoppingCartId(shoppingCartItem.getShoppingCartId());
        return shoppingCartItemDtoResponse;
    }

    @Override
    public ShoppingCartItemDtoResponse getShoppingCartItemById(GetShoppingCartItemDtoRequest shoppingCartItemGetRequest) {
        ShoppingCartItem shoppingCartItem = shoppingCartRepository.findById(shoppingCartItemGetRequest.getShoppingCartId()).orElse(null);
        return getShoppingCartItemDtoResponse(shoppingCartItem);
    }

    private ShoppingCartItemUpdateResponse getShoppingCartItemUpdateResponse(ShoppingCartItemUpdateRequest shoppingCartItemUpdateRequest, ShoppingCartItem shoppingCartItem) {
        if (shoppingCartItem == null) {
            throw new NullPointerException("Shopping Cart Item not found");
        }else {
            if (shoppingCartItemUpdateRequest.getStatus() != null) {
                shoppingCartItem.setStatus(shoppingCartItemUpdateRequest.getStatus());
            }
            if (shoppingCartItemUpdateRequest.getTaxRate() != shoppingCartItem.getTaxRate()) {
                shoppingCartItem.setTaxRate(shoppingCartItemUpdateRequest.getTaxRate());
                double newTaxRateDecimal = shoppingCartItemUpdateRequest.getTaxRate();
                double newSubTotal = shoppingCartItemUpdateRequest.getItems().getSubTotal();
                double newTaxAmount = newSubTotal * newTaxRateDecimal;
                double subTotalAmount = newSubTotal + newTaxAmount;
                shoppingCartItem.setTotalPrice(subTotalAmount);
            }
        }
        shoppingCartRepository.save(shoppingCartItem);
        ShoppingCartItemUpdateResponse shoppingCartItemUpdateResponse = new ShoppingCartItemUpdateResponse();
        shoppingCartItemUpdateResponse.setCreationDate(LocalDateTime.now());
        shoppingCartItemUpdateResponse.setStatus(shoppingCartItem.getStatus());
        shoppingCartItemUpdateResponse.setTotalPrice(shoppingCartItem.getTotalPrice());
        shoppingCartItemUpdateResponse.setMessage(("Shopping Cart Item Updated"));
        return shoppingCartItemUpdateResponse;
    }
}
