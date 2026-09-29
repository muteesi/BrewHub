package milestone1_strategy;

/**
 * Order is the "context" in the Strategy pattern. It HAS-A
 * PricingStrategy and delegates the pricing calculation to it instead
 * of branching on discount type itself. Swapping strategies at runtime
 * (e.g. a loyalty upgrade mid-session) is just a setter call.
 */
public class Order {
    private double subtotal;
    private PricingStrategy pricingStrategy;

    public Order(double subtotal, PricingStrategy pricingStrategy) {
        this.subtotal = subtotal;
        this.pricingStrategy = pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double getTotal() {
        return pricingStrategy.calculateTotal(subtotal);
    }

    public double getSubtotal() {
        return subtotal;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }
}
