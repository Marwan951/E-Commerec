import Products.Exp_ship;
import Products.Expirable;
import Products.Shippable;
import Products.product;
import Services.checkout_details;
import Services.shipping_service;
import User.Cart;
import User.Customer;
import User.Item;

import java.util.Map;
import java.util.OptionalDouble;

public class Main {
    public static void main(String []args) throws IllegalAccessException {
        product cheese = new Exp_ship("Veta",20,100,"2030,1,1",250);
        product cheese1 = new Exp_ship("s",20,100,"2030,1,1",250);
        product TV = new Shippable("Samsung TV",10000,200,2000);
        product Biscuits = new Expirable("Lambada",15,100,"2028,1,1");
        product MobScratchCard = new Shippable("MobSCard",40,90,20);
        product laptop = new product("Lenovo",50000,50 );


        //Customer
        Customer customer = new Customer("Marwan Salah",50000);
        Cart cart = new Cart();
        shipping_service shipping_service = new shipping_service();
        checkout_details ChechOut = new checkout_details();

        //cart
        cart.add(new Item(cheese,3));
        cart.add(new Item(MobScratchCard,2));
        cart.add(new Item(TV,3));

        //Ship
        shipping_service.ship(cart);

        //Checkout
        ChechOut.checkout(customer,cart);



    }

}
