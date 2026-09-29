package milestone3_decorator;

/** New beverage type added for this milestone. */
public class ColdBrew extends Beverage {
    public ColdBrew() {
        description = "Cold Brew";
    }

    @Override
    public double cost() {
        return 2.49;
    }
}
