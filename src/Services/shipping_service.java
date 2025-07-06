package Services;

import Products.Exp_ship;
import Products.Shippable;
import User.Cart;

import java.util.*;

public class shipping_service {

    public void ship(Cart cart){
        double TWeight = 0.0;
        //Map for product and quantity
        Map<String ,Integer> Name_Quntity = new HashMap<>();
        if(cart.shippableItems().isEmpty() )return ;

        for (Exp_ship j:  cart.ExpShipItems()){
            Name_Quntity.put(j.getName(),Name_Quntity.getOrDefault(j.getName(),0)+1);
            TWeight += j.getWeight();
        }
        for (Shippable i:  cart.shippableItems()) {
            Name_Quntity.put(i.getName(), Name_Quntity.getOrDefault(i.getName(),0)+1);
            TWeight += i.getWeight();
        }
        boolean ship = ( ! cart.shippableItems().isEmpty() || ! cart.ExpShipItems().isEmpty());
        if (ship) printShipDetails(cart,Name_Quntity,TWeight);
    }
    public void printShipDetails(Cart cart, Map<String, Integer> Name_Quantity, double total){
        System.out.println("** Shipment notice **");

        for (Map.Entry<String, Integer> entry : Name_Quantity.entrySet()) {
            OptionalDouble i;
            i =  cart.shippableItems().stream()
                    .filter(x -> x.getName()
                    .equals(entry.getKey()))
                    .mapToDouble(Shippable::getWeight)
                    .findFirst();
            if(! i.isPresent() ){
                 i =  cart.ExpShipItems().stream()
                        .filter(x -> x.getName()
                        .equals(entry.getKey()))
                        .mapToDouble(Exp_ship::getWeight)
                        .findFirst();
            }
            System.out.println(entry.getValue() + "x " + entry.getKey() + "\t\t"+ i.orElse(0.0) *entry.getValue()+ " g");
        }
        System.out.printf("Total package weight %.1f g \n", total);
        System.out.println("================================");
    }
}