package strategy;

import entities.Payment;

public class CreditCardProcessor implements PaymentProcessor{
    public void processPayment(Payment payment) {
        System.out.println("CreditCardProcessor processPayment");
    }
}
