package milestone4_factory;

public class NairobiIngredientFactory implements IngredientFactory {
    public Beans createBeans() { return new NairobiBeans(); }
    public Milk createMilk() { return new NairobiMilk(); }
    public Cup createCup() { return new NairobiCup(); }
}
