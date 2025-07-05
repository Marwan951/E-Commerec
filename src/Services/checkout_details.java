package Services;
import Products.*;
import User.*;

import java.sql.SQLOutput;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class checkout_details {

    public void checkout(Customer customer, Cart cart) throws IllegalAccessException {
     //Cart is empty
     if(cart.isEmpty()) {
         throw new IllegalAccessException("Cart is empty");
     }
     //one product is out of stock or expired.
     /*for (Item i: cart.items) {

         if (! i.checkAvailability(i.quantity,100)){
             throw new IllegalAccessException(i.p.getName() + " is out of stock");
         }
         if(! i.p.isExpired()){
             throw new IllegalAccessException(i.p.getName() + " is expired");
         }
     }*/
     //get total pay + shipping cost
     double Total = cart.getTPrice();
     double shipping_cost = 30.0;
     double To_Pay = 0.0;
     //shipping cost is 10$, if it's requested
     if (! cart.shippableItems().isEmpty()) {
         To_Pay = Total + shipping_cost;
     }

     //Pay
     customer.pay(customer,To_Pay);

     //print receipt
        System.out.println("** Checkout receipt **");
        for (Item item : cart.getItems()) {
            System.out.println(item.quantity + "x " + item.p.getName() + " " + (item.quantity * item.p.getPrice()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + Total);
        System.out.println("Shipping " + shipping_cost);
        System.out.println("Amount " + To_Pay);
 }
    public void printReceipt(Cart cart, double subtotal, double shipping, double total){
        System.out.println();
        System.out.println("======================");
        System.out.println("Checkout");
    }
}
