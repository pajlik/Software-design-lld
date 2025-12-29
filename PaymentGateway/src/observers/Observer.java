package observers;

import entities.Payment;

public interface Observer {
    public void update(Payment payment);
}
