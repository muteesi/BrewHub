package milestone2_observer;

/** Pushes a status update to the customer's mobile app, only when READY. */
public class CustomerNotifier implements Observer {
    @Override
    public void update(OrderStatusPublisher publisher) {
        Order o = publisher.getCurrentOrder();
        if (o.getStatus() == Order.Status.READY) {
            System.out.println("[CustomerNotifier] Push: your order " + o.getOrderId() + " is ready!");
        }
    }
}
