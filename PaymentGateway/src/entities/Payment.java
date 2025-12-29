package entities;

import enums.PaymentMode;
import observers.Customer;
import observers.Merchant;

public class Payment {
    private double amount;
    private String currency;
    private PaymentMode paymentMode;
    private Customer customer;
    private Merchant merchant;

    public Payment(String currency, double amount, PaymentMode paymentMode, Customer customer, Merchant merchant) {
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.customer = customer;
        this.merchant = merchant;
        this.currency = currency;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Merchant getMerchant() {
        return merchant;
    }
}
