package Products;

public  class product {
    //name, price and quantity.
    private String name;
    private double price;
    private int quantity;

    public product() {
    }
    public product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return false;
    }
    public boolean is_available(int required_quantity){
        return (required_quantity <= quantity );
    }
    public void decrease_quantity(int quantity){
        this.quantity -= quantity;
    }
}
