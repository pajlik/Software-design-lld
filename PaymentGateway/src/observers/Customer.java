package observers;

import entities.Payment;

public class Customer implements Observer {
    private int id;
    private String firstName;
    private String lastName;
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void update(Payment payment) {
        System.out.println("Transferred " + payment.getCurrency() + payment.getAmount() + " to " + payment.getMerchant().getAccountNumber() + " via " + payment.getPaymentMode().toString());
    }
}
