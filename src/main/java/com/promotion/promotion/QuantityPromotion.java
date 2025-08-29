package com.promotion.promotion;
import com.promotion.model.CartItem;
import  java.util.Map;

public class QuantityPromotion implements  Promotion{
 private String sku;
 private int requiredQty;
 private int promoPrice;

    public QuantityPromotion(String sku, int requiredQty, int promoPrice) {
        this.sku = sku;
        this.requiredQty = requiredQty;
        this.promoPrice = promoPrice;
    }

    @Override
    public int apply(Map<String, CartItem> cartItems) {

        CartItem item=cartItems.get(sku);
        if(item==null)  return 0;
        int qty=item.getQuantity();
        int unitPrice=item.getProduct().getPrice();
        int promoBundles=qty/requiredQty;
        int remaining=qty%requiredQty;
        //Update quantity lest after applying promotion
        item.setQuantity(remaining);
        return promoBundles*promoPrice;
    }
}
