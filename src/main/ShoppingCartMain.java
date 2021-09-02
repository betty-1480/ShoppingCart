package main;

import payment.PayPal;
import shoppingCart.Cart;
import shoppingCart.Item;

public class ShoppingCartMain {

    public static void main(String...args){
        Item item1=new Item("i001",10.00);
        Item item2=new Item("i002",20.00);
        Item item3=new Item("i003",30.00);

        Cart cart=Cart.getInstance();
        cart.addItem(item1,10);
        cart.addItem(item2,2);
        cart.addItem(item3,1);
        cart.setPaymentStrategy(new PayPal());
        cart.confirmPayment();
    }

}
