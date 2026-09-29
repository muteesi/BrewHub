package milestone1_strategy;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(20.00, new NoDiscountStrategy());
        System.out.printf("%-30s subtotal=%.2f  total=%.2f%n",
                order.getPricingStrategy(), order.getSubtotal(), order.getTotal());

        order.setPricingStrategy(new StudentDiscountStrategy());
        System.out.printf("%-30s subtotal=%.2f  total=%.2f%n",
                order.getPricingStrategy(), order.getSubtotal(), order.getTotal());

        order.setPricingStrategy(new HappyHourStrategy());
        System.out.printf("%-30s subtotal=%.2f  total=%.2f%n",
                order.getPricingStrategy(), order.getSubtotal(), order.getTotal());

        // Customer starts as bronze, then gets upgraded to gold mid-session --
        // same Order instance, no if/else, just a strategy swap.
        order.setPricingStrategy(new LoyaltyTierStrategy(LoyaltyTierStrategy.Tier.BRONZE));
        System.out.printf("%-30s subtotal=%.2f  total=%.2f%n",
                order.getPricingStrategy(), order.getSubtotal(), order.getTotal());

        order.setPricingStrategy(new LoyaltyTierStrategy(LoyaltyTierStrategy.Tier.GOLD));
        System.out.printf("%-30s subtotal=%.2f  total=%.2f%n",
                order.getPricingStrategy(), order.getSubtotal(), order.getTotal());
    }
}
