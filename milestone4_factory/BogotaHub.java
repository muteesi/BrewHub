package milestone4_factory;

public class BogotaHub extends RoastingHub {
    public BogotaHub() {
        super(new BogotaIngredientFactory());
    }

    @Override
    public Beans createBeans() {
        return new BogotaBeans();
    }
}
