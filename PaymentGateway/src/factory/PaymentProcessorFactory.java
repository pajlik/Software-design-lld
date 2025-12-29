package factory;

import enums.PaymentMode;
import strategy.CreditCardProcessor;
import strategy.PaymentProcessor;
import strategy.UPIProcessor;

public class PaymentProcessorFactory {
    public static PaymentProcessor createPaymentProcessor(PaymentMode paymentMode) {
        return switch (paymentMode) {
            case UPI -> new UPIProcessor();
            case CREDIT_CARD -> new CreditCardProcessor();
            default -> new UPIProcessor();
        };
    }
}
