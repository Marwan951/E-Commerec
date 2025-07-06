package Products;

import Interfaces.shipping;

public class Shippable extends product implements shipping {
    public double weight;

    public Shippable(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
