import entities.Payment;
import enums.PaymentMode;
import observers.Customer;
import observers.Merchant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentGatewaySystem system = PaymentGatewaySystem.getInstance();
        Customer customer = new Customer();
        Merchant merchant = new Merchant();
        Payment payment = new Payment("$", 12, PaymentMode.PAYPAL, customer, merchant);
        system.makePayment(payment);
    }
}

