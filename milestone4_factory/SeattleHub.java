package milestone4_factory;

public class SeattleHub extends RoastingHub {
    public SeattleHub() {
        super(new SeattleIngredientFactory());
    }

    @Override
    public Beans createBeans() {
        return new SeattleBeans();
    }
}
