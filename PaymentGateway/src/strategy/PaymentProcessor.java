package strategy;

import entities.Payment;

public interface PaymentProcessor {
    public void processPayment(Payment payment);
}
