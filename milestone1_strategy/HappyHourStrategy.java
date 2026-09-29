package milestone1_strategy;

/** 20% off, applied only during the 3-5pm happy-hour window. */
public class HappyHourStrategy implements PricingStrategy {
    private static final double DISCOUNT_RATE = 0.20;

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal * (1 - DISCOUNT_RATE);
    }

    @Override
    public String toString() {
        return "Happy Hour (20% off)";
    }
}
