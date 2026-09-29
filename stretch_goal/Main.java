package stretch_goal;

import milestone2_observer.Order;
import milestone2_observer.OrderStatusPublisher;

public class Main {
    public static void main(String[] args) {
        OrderStatusPublisher publisher = new OrderStatusPublisher();
        publisher.registerObserver(new LedgerObserver(5.25));

        Order order = new Order("ORD-2001", Order.Status.QUEUED);
        publisher.setCurrentOrder(order);   // no ledger entry yet

        order.setStatus(Order.Status.BREWING);
        publisher.setCurrentOrder(order);   // still no ledger entry

        order.setStatus(Order.Status.READY);
        publisher.setCurrentOrder(order);   // ledger records exactly here
    }
}
