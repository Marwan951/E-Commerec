package User;

public class Customer {
    protected String name;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    private boolean check_balance(double CBalance, double TPrice) throws IllegalAccessException {
        if(TPrice > CBalance) throw new IllegalAccessException("Balance is not enough");
        return (TPrice <= CBalance);
    }
    //Customer's balance is insufficient.
    public boolean pay (Customer customer, double TPrice) throws IllegalAccessException {
        if(check_balance(customer.balance,TPrice)){
            this.balance-=TPrice;
            return true;
        }
    return false;
    }
}
