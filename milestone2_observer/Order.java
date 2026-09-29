package milestone2_observer;

/** Plain data holder for one order's current status. */
public class Order {
    public enum Status { QUEUED, BREWING, READY }

    private final String orderId;
    private Status status;

    public Order(String orderId, Status status) {
        this.orderId = orderId;
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "Order{" + orderId + ", " + status + "}";
    }
}
