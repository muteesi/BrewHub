package milestone3_decorator;

/**
 * Decorator: IS-A Beverage (so it can stand in for one) and also
 * HAS-A Beverage (the object it wraps). Every concrete condiment
 * extends this and calls back into the wrapped beverage for both
 * cost() and getDescription(), then adds its own contribution.
 */
public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    @Override
    public abstract String getDescription();
}
