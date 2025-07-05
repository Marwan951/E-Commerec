package Products;

import Interfaces.shipping;

public class Exp_ship extends Expirable implements shipping {
    double weight;

    public Exp_ship(String name, double price, int quantity, String expiry_date, double weight) {
        super(name, price, quantity, expiry_date);
        this.weight = weight;
    }
    @Override
    public double getWeight() {return 0;}
}
