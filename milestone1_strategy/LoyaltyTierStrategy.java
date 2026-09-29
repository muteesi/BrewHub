package milestone1_strategy;

/**
 * Discount depends on the customer's loyalty tier. Because the tier is
 * passed in at construction time, upgrading a customer mid-session is as
 * simple as building a new strategy instance and calling
 * order.setPricingStrategy(...) -- no changes to Order itself.
 */
public class LoyaltyTierStrategy implements PricingStrategy {

    public enum Tier {
        BRONZE(0.05),
        SILVER(0.10),
        GOLD(0.18);

        final double rate;
        Tier(double rate) { this.rate = rate; }
    }

    private final Tier tier;

    public LoyaltyTierStrategy(Tier tier) {
        this.tier = tier;
    }

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal * (1 - tier.rate);
    }

    @Override
    public String toString() {
        return "Loyalty Tier " + tier + " (" + (int) (tier.rate * 100) + "% off)";
    }
}
