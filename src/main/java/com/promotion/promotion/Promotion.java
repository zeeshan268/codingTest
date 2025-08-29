package com.promotion.promotion;
import com.promotion.model.CartItem;
import java.util.Map;

public interface Promotion {
    int apply(Map<String,CartItem> cartItems);
}
