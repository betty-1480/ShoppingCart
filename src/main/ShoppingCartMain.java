package main;

import item.Fruit;
import item.Vegetable;
import payment.PayPal;
import shoppingCart.Cart;
import item.Item;

public class ShoppingCartMain {

    public static void main(String...args){
        Item item1=new Item("i001",10.00);
        item1.setItemType(new Vegetable());
        Item item2=new Item("i002",20.00);
        item2.setItemType(new Fruit());
        Item item3=new Item("i003",30.00);
        item3.setItemType(new Fruit());

        Cart cart=Cart.getInstance();
        cart.addItem(item1,10);
        cart.addItem(item2,2);
        cart.addItem(item3,1);
        cart.setPaymentStrategy(new PayPal());
        cart.confirmPayment();
    }

}
