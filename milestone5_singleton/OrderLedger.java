package milestone5_singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton, using double-checked locking (see README for why this
 * fix was chosen over plain `synchronized` or eager initialization).
 */
public class OrderLedger {
    // volatile is required for double-checked locking to be safe under
    // the Java Memory Model -- without it, another thread could observe
    // a partially-constructed OrderLedger.
    private static volatile OrderLedger instance;

    private final List<Double> transactions = new ArrayList<>();

    private OrderLedger() {
        // Guard against reflection-based instantiation creating a second
        // instance once `instance` is already set.
        if (instance != null) {
            throw new IllegalStateException("OrderLedger already constructed -- use getInstance()");
        }
    }

    public static OrderLedger getInstance() {
        OrderLedger result = instance;
        if (result == null) {                      // first check, no lock
            synchronized (OrderLedger.class) {
                result = instance;
                if (result == null) {               // second check, locked
                    instance = result = new OrderLedger();
                }
            }
        }
        return result;
    }

    public synchronized void recordTransaction(double amount) {
        transactions.add(amount);
    }

    public synchronized double getTotalRevenue() {
        double sum = 0;
        for (double t : transactions) sum += t;
        return sum;
    }

    public synchronized int getTransactionCount() {
        return transactions.size();
    }
}
