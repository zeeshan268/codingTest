package com.promotion.main;
import com.promotion.model.CartItem;
import com.promotion.model.Product;
import com.promotion.promotion.ComboPromotion;
import com.promotion.promotion.Promotion;
import com.promotion.promotion.QuantityPromotion;
import com.promotion.service.PromotionEngine;
import java.util.*;



public class PromotionEngineDemo {

    public static  void main(String[] args)
    {
    // Define products
        Map<String,Product> products=new HashMap<>();
        products.put("A", new Product("A",50));
        products.put("B", new Product("B",30));
        products.put("C", new Product("C",20));
        products.put("D", new Product("D",15));

    // Define active promotions
        List<Promotion>promotions=new ArrayList<>();
        promotions.add(new QuantityPromotion("A",3,130));
        promotions.add(new QuantityPromotion("B",2,45));
        promotions.add(new ComboPromotion("C","D",30));
       com.promotion.service.PromotionEngine engine =new PromotionEngine(promotions);
    // Scenario A: 1*A , 1*B,  1*C
        Map<String,CartItem> cartA=new HashMap<>();
        cartA.put("A", new CartItem(products.get("A"),1));
        cartA.put("B", new CartItem(products.get("B"),1));
        cartA.put("C", new CartItem(products.get("C"),1));
        System.out.println("Schenario A Total: "+engine.calculateTotal(cartA));
    // Scenario B: 5*A, 5*B, 1*C
        Map<String,CartItem> cartB=new HashMap<>();
        cartA.put("A", new CartItem(products.get("A"),5));
        cartA.put("B", new CartItem(products.get("B"),5));
        cartA.put("C", new CartItem(products.get("C"),1));
        System.out.println("Schenario B Total: "+engine.calculateTotal(cartA));
    //Scenario C : 3*A, 5*B, 1*C, 1*D
        Map<String,CartItem> cartC=new HashMap<>();
        cartA.put("A", new CartItem(products.get("A"),3));
        cartA.put("B", new CartItem(products.get("B"),5));
        cartA.put("C", new CartItem(products.get("C"),1));
        cartA.put("D", new CartItem(products.get("D"),1));
        System.out.println("Schenario C Total: "+engine.calculateTotal(cartA));


    }
}

