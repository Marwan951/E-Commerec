package User;

import Products.Exp_ship;
import Products.Shippable;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void add(Item i){
        items.add(i);
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public double getTPrice(){
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    public List<Shippable> shippableItems(){
    List<Shippable> shippables = new ArrayList<>();
        for (Item i :items) {
            if(i.p instanceof Shippable){
                int q = i.quantity;
                while (q>0){
                    shippables.add((Shippable) i.p);
                    q--;
                }
            }
        }

        return shippables;
    }

}
