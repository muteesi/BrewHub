package milestone2_observer;

/** Decrements stock the moment an order starts brewing. */
public class InventoryTracker implements Observer {
    @Override
    public void update(OrderStatusPublisher publisher) {
        Order o = publisher.getCurrentOrder();
        if (o.getStatus() == Order.Status.BREWING) {
            System.out.println("[InventoryTracker] Deducting ingredients for " + o.getOrderId());
        }
    }
}
