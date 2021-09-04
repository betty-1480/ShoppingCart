package main;

import item.Fruit;
import item.Vegetable;
import payment.PayPal;
import payment.PaymentStrategy;
import shoppingCart.Cart;
import item.Item;

import java.lang.reflect.Proxy;

public class ShoppingCartMain {

    @SuppressWarnings("unchecked")

    public static <T> T wrapWithLoggingProxy(T target, Class<T> klass) {
        return (T) Proxy.newProxyInstance(
                klass.getClassLoader(),
                new Class<?>[] {klass},
                new LoggingHandler(target));  //the invocation handler to dispatch method invocations to a proxy instance
    }

    public static void main(String...args){

        Cart cart=Cart.getInstance();

        Item item1=new Vegetable("i001",10.00);
        Item item2=new Fruit("i002",20.00);

        cart.addItem(item1,10);
        cart.addItem(item2,2);
        cart.setPaymentStrategy(new PayPal());
        cart.confirmPayment();
    }

}
