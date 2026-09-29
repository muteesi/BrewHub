package milestone4_factory;

/**
 * RoastingHub combines two patterns:
 *  - Factory Method: createBeans() is abstract; each concrete hub
 *    decides which concrete Beans class it produces.
 *  - Abstract Factory: every hub is built with exactly one
 *    IngredientFactory for its region, injected once by its own
 *    constructor (not settable afterward), which is the only source
 *    of Milk and Cup. Because a subclass's constructor is the single
 *    place that both createBeans() is overridden AND the
 *    IngredientFactory is chosen, and there is no setter for either,
 *    it is structurally impossible to end up with parts from two
 *    different regions on the same hub.
 */
public abstract class RoastingHub {
    protected final IngredientFactory ingredientFactory;

    protected RoastingHub(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /** Factory Method -- overridden per hub. */
    public abstract Beans createBeans();

    /** Assembles one order's worth of ingredients for this hub's region. */
    public String brewOrder() {
        Beans beans = createBeans();
        Milk milk = ingredientFactory.createMilk();
        Cup cup = ingredientFactory.createCup();
        return String.format("Beans: %s | Milk: %s | Cup: %s",
                beans.getOrigin(), milk.getSupplier(), cup.getSupplier());
    }
}
