package milestone1_strategy;

/** Flat 15% off for verified students. */
public class StudentDiscountStrategy implements PricingStrategy {
    private static final double DISCOUNT_RATE = 0.15;

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal * (1 - DISCOUNT_RATE);
    }

    @Override
    public String toString() {
        return "Student Discount (15% off)";
    }
}
