package stretch_goal;

import milestone2_observer.Observer;
import milestone2_observer.Order;
import milestone2_observer.OrderStatusPublisher;
import milestone5_singleton.OrderLedger;

/**
 * Stretch goal: OrderLedger doesn't implement Observer itself (it lives
 * in a separate milestone and shouldn't need to know about Observer),
 * so this small adapter subscribes to the publisher on the Singleton's
 * behalf and only calls recordTransaction() once an order reaches
 * READY -- exactly the point at which a sale is actually final.
 */
public class LedgerObserver implements Observer {
    private final double pricePerOrder;

    public LedgerObserver(double pricePerOrder) {
        this.pricePerOrder = pricePerOrder;
    }

    @Override
    public void update(OrderStatusPublisher publisher) {
        Order order = publisher.getCurrentOrder();
        if (order.getStatus() == Order.Status.READY) {
            OrderLedger.getInstance().recordTransaction(pricePerOrder);
            System.out.println("[LedgerObserver] Recorded " + order.getOrderId()
                    + " -- ledger total now " + OrderLedger.getInstance().getTotalRevenue());
        }
    }
}
