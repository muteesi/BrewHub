package milestone1_strategy;

/** Default strategy: full price, no discount applied. */
public class NoDiscountStrategy implements PricingStrategy {
    @Override
    public double calculateTotal(double subtotal) {
        return subtotal;
    }

    @Override
    public String toString() {
        return "No Discount";
    }
}
