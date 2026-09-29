package milestone5_singleton;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int hubThreads = 8;
        int transactionsPerHub = 1000;
        double amountPerTransaction = 4.50;

        CountDownLatch latch = new CountDownLatch(hubThreads);
        // Track every getInstance() result to prove they're all the same object.
        OrderLedger[] seen = new OrderLedger[hubThreads];

        for (int i = 0; i < hubThreads; i++) {
            final int idx = i;
            Thread hubCheckoutThread = new Thread(() -> {
                OrderLedger ledger = OrderLedger.getInstance();
                seen[idx] = ledger;
                for (int t = 0; t < transactionsPerHub; t++) {
                    ledger.recordTransaction(amountPerTransaction);
                }
                latch.countDown();
            }, "hub-checkout-" + i);
            hubCheckoutThread.start();
        }

        latch.await();

        boolean allSameInstance = true;
        for (OrderLedger l : seen) {
            if (l != seen[0]) allSameInstance = false;
        }

        OrderLedger ledger = OrderLedger.getInstance();
        int expectedCount = hubThreads * transactionsPerHub;
        System.out.println("All threads got the same instance: " + allSameInstance);
        System.out.println("Expected transactions: " + expectedCount
                + " | Actual: " + ledger.getTransactionCount());
        System.out.printf("Total revenue: %.2f (expected %.2f)%n",
                ledger.getTotalRevenue(), expectedCount * amountPerTransaction);
    }
}
