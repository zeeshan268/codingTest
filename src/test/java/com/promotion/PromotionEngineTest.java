package com.promotion;
import com.promotion.model.CartItem;
import com.promotion.model.Product;
import com.promotion.promotion.ComboPromotion;
import com.promotion.promotion.Promotion;
import com.promotion.promotion.QuantityPromotion;
import com.promotion.service.PromotionEngine;
import  org.junit.jupitor.api.BeforeEach;
import org.junit.jupitor.api.Test;
import java.util.*;
import static org.junit.jupitor.api.Assertions.assertEquals;


public class PromotionEngineTest {

private Map<String , Product> products;
private List<Promotion>promotions;
private PromotionEngine engine;
@BeforeEach
    void setup()
{
products=new HashMap<>();
    products.put("A",new Product("A",50));
    products.put("B",new Product("B",30));
    products.put("C",new Product("C",20));
    products.put("D",new Product("D",15));

    promotions=new ArrayList<>();
    promotions.add(new QuantityPromotion("A",3,130));
    promotions.add(new QuantityPromotion("B",2,45));
    promotions.add(new ComboPromotion("C","D",30));

    engine=new PromotionEngine(promotions);


}

@Test
  void testScenarioA()
{
    Map<String ,CartItem> cartA = new HashMap<>();
    cartA.put("A", new CartItem(products.get("A"),1));
    cartA.put("B",new CartItem(products.get("B"),1));
    cartA.put("C",new CartItem(products.get("C"),1));
int total =engine.calculateTotal(cartA);
assertEquals(100,total,"Scenario A total should be 100");
}

@Test
void testScenarioB()
{
    Map<String ,CartItem> cartB = new HashMap<>();
    cartB.put("A", new CartItem(products.get("A"),5));
    cartB.put("B",new CartItem(products.get("B"),5));
    cartB.put("C",new CartItem(products.get("C"),1));
    int total =engine.calculateTotal(cartB;
    assertEquals(370,total,"Scenario B total should be 370");
}

    @Test
    void testScenarioC()
    {
        Map<String ,CartItem> cartC = new HashMap<>();
        cartC.put("A", new CartItem(products.get("A"),3));
        cartC.put("B",new CartItem(products.get("B"),5));
        cartC.put("C",new CartItem(products.get("C"),1));
        cartC.put("D",new CartItem(products.get("D"),1));
        int total =engine.calculateTotal(cartC;
        assertEquals(200,total,"Scenario B total should be 200");
    }



}
