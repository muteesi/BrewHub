package milestone3_decorator;

public class Drip extends Beverage {
    public Drip() {
        description = "Drip Coffee";
    }

    @Override
    public double cost() {
        return 1.49;
    }
}
