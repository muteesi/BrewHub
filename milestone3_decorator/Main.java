package milestone3_decorator;

public class Main {
    public static void main(String[] args) {
        // Stack 3+ condiments on the new beverage, in a specific order.
        Beverage drink = new ColdBrew();
        drink = new OatMilk(drink);
        drink = new VanillaSyrup(drink);
        drink = new ExtraShot(drink);
        drink = new Whip(drink);

        System.out.println(drink.getDescription());
        System.out.printf("$%.2f%n", drink.cost());

        // A second, differently-stacked drink to show combinations are unbounded.
        Beverage second = new Whip(new ExtraShot(new Espresso()));
        System.out.println(second.getDescription());
        System.out.printf("$%.2f%n", second.cost());
    }
}
