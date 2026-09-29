package milestone2_observer;

public class Main {
    public static void main(String[] args) {
        OrderStatusPublisher publisher = new OrderStatusPublisher();

        Observer kitchen = new KitchenDisplay();
        Observer customer = new CustomerNotifier();
        Observer inventory = new InventoryTracker();

        publisher.registerObserver(kitchen);
        publisher.registerObserver(customer);
        publisher.registerObserver(inventory);

        Order order = new Order("ORD-1001", Order.Status.QUEUED);
        publisher.setCurrentOrder(order);

        order.setStatus(Order.Status.BREWING);
        publisher.setCurrentOrder(order);

        // Inventory tracker unsubscribes at runtime -- e.g. it's done its
        // one job (deducting stock) and doesn't need further updates.
        publisher.removeObserver(inventory);

        order.setStatus(Order.Status.READY);
        publisher.setCurrentOrder(order);
    }
}
