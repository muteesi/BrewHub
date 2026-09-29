package milestone3_decorator;

/** New condiment added for this milestone. */
public class OatMilk extends CondimentDecorator {
    public OatMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Oat Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.65;
    }
}
