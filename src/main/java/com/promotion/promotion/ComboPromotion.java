package com.promotion.promotion;
import com.promotion.model.CartItem;
import java.util.Map;

public class ComboPromotion  implements Promotion{
private String sku1;
private String sku2;
private int comboprice;

    public ComboPromotion(String sku1, String sku2, int comboprice) {
        this.sku1 = sku1;
        this.sku2 = sku2;
        this.comboprice = comboprice;
    }


    @Override
    public int apply(Map<String, CartItem> cartItems) {

        CartItem item1=cartItems.get(sku1);
        CartItem item2=cartItems.get(sku2);
        if(item1==null || item2==null) return 0;
        int qty1=item1.getQuantity();
        int qty2=item2.getQuantity();
        int combos=Math.min(qty1,qty2);
        item1.setQuantity(qty1-combos);
        item2.setQuantity(qty2-combos);
        return  combos*comboprice;


    }
}
