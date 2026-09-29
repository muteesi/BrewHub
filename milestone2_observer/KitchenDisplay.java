package milestone2_observer;

/** Shows every order and its status on the in-store kitchen screen. */
public class KitchenDisplay implements Observer {
    @Override
    public void update(OrderStatusPublisher publisher) {
        Order o = publisher.getCurrentOrder();
        System.out.println("[KitchenDisplay] " + o.getOrderId() + " -> " + o.getStatus());
    }
}
