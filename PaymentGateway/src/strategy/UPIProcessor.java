package strategy;

import entities.Payment;

public class UPIProcessor implements PaymentProcessor{
    public void processPayment(Payment payment) {
        System.out.println("UPIProcessor processPayment");
    }
}
