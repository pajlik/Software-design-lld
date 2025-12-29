import entities.Payment;
import enums.PaymentMode;
import factory.PaymentProcessorFactory;
import observers.Customer;
import observers.Merchant;
import strategy.PaymentProcessor;

public class PaymentGatewaySystem {
    private static volatile PaymentGatewaySystem instance;
    private PaymentGatewaySystem() {}

    public static PaymentGatewaySystem getInstance() {
        if (instance == null) {
            synchronized (PaymentGatewaySystem.class) {
                if (instance == null) {
                    instance = new PaymentGatewaySystem();
                }
            }
        }
        return instance;
    }

    public void makePayment(Payment payment) {
        PaymentMode paymentMode = payment.getPaymentMode();
        PaymentProcessor processor = PaymentProcessorFactory.createPaymentProcessor(paymentMode);
        processor.processPayment(payment);
        notifyObservers(payment);
    }

    public void notifyObservers(Payment payment) {
        Customer customer = payment.getCustomer();
        Merchant merchant = payment.getMerchant();
        customer.update(payment);
        merchant.update(payment);
    }

}
