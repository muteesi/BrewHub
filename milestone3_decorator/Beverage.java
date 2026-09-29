package milestone3_decorator;

/** Component in the Decorator pattern. */
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
