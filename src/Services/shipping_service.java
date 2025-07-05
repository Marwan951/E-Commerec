package Services;

import Products.Shippable;
import User.Cart;

import java.util.*;

public class shipping_service {
    public void ship(List<Shippable> shippables, Cart cart){
        //Map for product and quantity
        double TWeight = 0.0;
        Map<String ,Integer> Name_Quntity = new HashMap<>();
        if(shippables.isEmpty())return ;
        for (Shippable i:   shippables) {
            Name_Quntity.put(i.getName(), Name_Quntity.getOrDefault(i.getName(),0)+1);
            TWeight += i.getWeight();
        }
        printShipDetails(cart,Name_Quntity,TWeight);
    }
    public void printShipDetails(Cart cart, Map<String, Integer> Name_Quantity, double total){
        System.out.println("** Shipment notice **");
        for (Map.Entry<String, Integer> entry : Name_Quantity.entrySet()) {
            OptionalDouble i =  cart.shippableItems().stream().filter(shippable -> shippable.getName()
                    .equals(entry.getKey())).mapToDouble(Shippable::getWeight).findFirst();

            System.out.println(entry.getValue() + "x " + entry.getKey() + " \s\s\s\s\s\s\s "+ i.orElse(0.0) *entry.getValue()+ " g");        }
        System.out.printf("Total package weight %.1f g \n", total);
        System.out.println("================================");
    }
}
