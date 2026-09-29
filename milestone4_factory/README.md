# Milestone 4 — Factory Method / Abstract Factory: Multi-Region Ingredient Sourcing

## Design

Two patterns work together here:

- **Factory Method** — `RoastingHub.createBeans()` is abstract; each
  concrete hub (`SeattleHub`, `BogotaHub`, `NairobiHub`) overrides it to
  return its own region's `Beans` implementation.
- **Abstract Factory** — `IngredientFactory` bundles `createBeans()`,
  `createMilk()`, `createCup()` into one family per region
  (`SeattleIngredientFactory`, `BogotaIngredientFactory`,
  `NairobiIngredientFactory`). Each `RoastingHub` subclass's constructor
  builds and passes its own matching factory into the base class, and
  that field is `final` with no setter, so `brewOrder()` always pulls
  `Milk`/`Cup` from the one regional family the hub was built with.

`Main` proves the third region (Nairobi) slots in with zero changes to
`RoastingHub`, `IngredientFactory`, or any existing hub — just three
new part classes, one new factory, and one new hub subclass.

## Why a mismatch is impossible

Because `ingredientFactory` is assigned exactly once, inside each hub's
own constructor, to the factory built for that same region, there's no
constructor, setter, or code path anywhere that lets a `SeattleHub` end
up holding a `BogotaIngredientFactory`. The invalid state (Seattle beans
shipped with Bogotá cups) isn't just avoided at runtime — it can't be
expressed in the type system at all.

## Design principle enforced

Abstract Factory here enforces the **Dependency Inversion Principle**
(depend on abstractions, not concretions): `RoastingHub.brewOrder()`
only ever talks to the `IngredientFactory`, `Beans`, `Milk`, and `Cup`
interfaces — never to a concrete `SeattleMilk` or `BogotaCup` directly.
The high-level policy (assembling an order) and the low-level regional
detail (which supplier's parts) both depend on the same set of
abstractions, which is exactly what lets a third region be added
without modifying any existing class.

## Run

```
javac milestone4_factory/*.java
java milestone4_factory.Main
```
