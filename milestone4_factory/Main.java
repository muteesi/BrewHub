package milestone4_factory;

public class Main {
    public static void main(String[] args) {
        RoastingHub[] hubs = { new SeattleHub(), new BogotaHub(), new NairobiHub() };

        for (RoastingHub hub : hubs) {
            System.out.println(hub.getClass().getSimpleName() + " -> " + hub.brewOrder());
        }

        // Why a mismatch is impossible: RoastingHub.ingredientFactory is
        // `final` and assigned exactly once,
        // inside each subclass's own constructor, to the matching
        // regional factory. There is no setIngredientFactory() and no
        // public constructor that takes an arbitrary IngredientFactory,
        // so there is no code path anywhere that could hand a SeattleHub
        // a BogotaIngredientFactory -- the mismatch this system guards
        // against (Seattle beans shipped with Bogota cups) simply has no
        // way to be expressed in the type system.
    }
}
