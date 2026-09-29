package milestone2_observer;

/**
 * Pull-style Observer: notify() only tells the observer that *something*
 * changed on the given publisher. The observer pulls whatever data it
 * actually needs via publisher getters. See README for why pull was
 * chosen over push here.
 */
public interface Observer {
    void update(OrderStatusPublisher publisher);
}
