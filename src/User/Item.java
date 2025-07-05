package User;

import Products.product;

import java.util.OptionalInt;

public class Item {
    public product p ;
    public int quantity;

    public Item(product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
    }
    public double getTotalPrice(){
        return this.quantity * p.getPrice();
    }
    public boolean checkAvailability(int qua, int TQ){

        return (qua < TQ);
    }
}
