package milestone4_factory;

/**
 * Abstract Factory: bundles a full, matched family of parts for one
 * region. A concrete factory (SeattleIngredientFactory, etc.) is the
 * *only* place region-specific classes get instantiated, so it is
 * physically impossible to hand out a Beans from one region alongside
 * a Cup from another -- you only ever get one factory, and everything
 * it produces belongs to the same family.
 */
public interface IngredientFactory {
    Beans createBeans();
    Milk createMilk();
    Cup createCup();
}
