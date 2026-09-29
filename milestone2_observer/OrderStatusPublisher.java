package milestone2_observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject. Holds the current order and the list of interested
 * observers. OrderService (or whatever drives state transitions) calls
 * setCurrentOrder(...) whenever an order changes state, and that's the
 * only place notifyObservers() gets triggered from.
 */
public class OrderStatusPublisher implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private Order currentOrder;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // Copy the list so an observer that unsubscribes itself
        // mid-notification doesn't cause a ConcurrentModificationException.
        for (Observer o : new ArrayList<>(observers)) {
            o.update(this);
        }
    }

    /** Called by OrderService whenever an order's status changes. */
    public void setCurrentOrder(Order order) {
        this.currentOrder = order;
        notifyObservers();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
