package shoppingCart;


import item.Item;
import payment.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class Cart{
    private static Cart cart;
    private Map<Item,Integer> cartItems;
    private PaymentStrategy paymentStrategy;

    private Cart(){}

    public static Cart getInstance(){
        if (cart==null){
            cart=new Cart();
        }
            return cart;
    }

    public synchronized void addItem(Item item, int quantity){
        if (cartItems==null)
            cartItems=new HashMap<>();
        if (cartItems.containsKey(item)){
            int oldQty=cartItems.get(item);
                cartItems.merge(item,oldQty,(a,b)->oldQty+quantity);
        }
        else
            cartItems.put(item,quantity);
    }

    public synchronized void removeItem(Item item, int quantity){
        if (cartItems!=null){
            if (cartItems.containsKey(item)){
                int oldQty=cartItems.get(item);
                if (oldQty>=quantity)
                cartItems.merge(item,oldQty,(a,b)->oldQty-quantity);
            }
        }
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public void confirmPayment(){
        if (paymentStrategy==null)
            System.out.println("Select a payment method");
        paymentStrategy.makePayment();
    }
}
