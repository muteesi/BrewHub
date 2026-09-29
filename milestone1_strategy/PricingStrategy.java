package milestone1_strategy;

/**
 * Strategy interface: each concrete strategy encapsulates one way of
 * turning a subtotal into a final charge. Order never needs to know
 * *how* a discount is computed -- it just delegates.
 */
public interface PricingStrategy {
    double calculateTotal(double subtotal);
}
