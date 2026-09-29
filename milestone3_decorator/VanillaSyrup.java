package milestone3_decorator;

/** New condiment added for this milestone. */
public class VanillaSyrup extends CondimentDecorator {
    public VanillaSyrup(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Vanilla Syrup";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.55;
    }
}
