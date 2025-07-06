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
     for (Item i: cart.items) {

         if (! i.checkAvailability(i.quantity,i.p.getQuantity())){
             throw new IllegalAccessException(i.p.getName() + " is out of stock");
         }
         if(i.p instanceof Expirable || i.p instanceof Exp_ship) {
             if (i.p.isExpired(((Expirable) i.p).expiry_date)) {
                 throw new IllegalAccessException(i.p.getName() + " is expired");
             }
         }
     }
     //get total pay + shipping cost
     double Total = cart.getTPrice();
     double shipping_cost = 30.0;
     double To_Pay = Total;
     //shipping cost is 10$, if it's requested
     boolean ship = ( ! cart.shippableItems().isEmpty() || ! cart.ExpShipItems().isEmpty());
        if (ship) {
         To_Pay = Total + shipping_cost;
     }

     //Pay
     customer.pay(customer,To_Pay);

     //print receipt
        printReceipt(cart,Total,shipping_cost,To_Pay,ship);
 }
    public void printReceipt(Cart cart, double subtotal, double shipping, double total, boolean ship){

        System.out.println("** Checkout receipt **");
        for (Item item : cart.getItems()) {
            System.out.println(item.quantity + "x " + item.p.getName() + " " + (item.quantity * item.p.getPrice()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        if(ship) System.out.println("Shipping " + shipping);
        System.out.println("Amount " + total);
    }
}
