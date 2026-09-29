package milestone4_factory;

/** Third region, added to prove the design extends cleanly. */
public class NairobiHub extends RoastingHub {
    public NairobiHub() {
        super(new NairobiIngredientFactory());
    }

    @Override
    public Beans createBeans() {
        return new NairobiBeans();
    }
}
