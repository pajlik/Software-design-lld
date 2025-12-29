package observers;

import entities.Payment;

public class Merchant implements Observer {
    private int id;
    private String firstName;
    private String lastName;
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void update(Payment payment) {
        System.out.println("Received " + payment.getCurrency() + payment.getAmount() + " from " + payment.getCustomer().getAccountNumber() + " via " + payment.getPaymentMode().toString());
    }
}
