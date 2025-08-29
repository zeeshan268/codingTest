package com.promotion.service;
import com.promotion.model.CartItem;
import com.promotion.promotion.Promotion;

import java.util.List;
import java.util.Map;

public class PromotionEngine {
    private List<Promotion> promotions;

    public PromotionEngine(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public  int calculateTotal(Map<String, CartItem> cartItems)
    {

        int total=0;
        for (Promotion promo: promotions  )
        {
            total+=promo.apply(cartItems);
        }

        for(CartItem item : cartItems.values())

        {
            total+= item.getQuantity()*item.getProduct().getPrice();
        }
        return total;


    }

}
