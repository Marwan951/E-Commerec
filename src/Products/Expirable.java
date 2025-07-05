package Products;

import java.time.LocalDate;

public class Expirable extends product {
    String expiry_date = null;

    public Expirable(String name, double price, int quantity, String expiry_date) {
        super(name, price, quantity);
        this.expiry_date = expiry_date;
    }

    @Override
    public boolean isExpired() {
        String [] exp_d = expiry_date.split(",");
        LocalDate exp_date = LocalDate.of(Integer.parseInt(exp_d[0].trim()),
                Integer.parseInt(exp_d[1].trim()),Integer.parseInt(exp_d[2].trim()) );
        return (exp_date.isBefore(LocalDate.now()));
    }
}
