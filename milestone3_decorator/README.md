# Milestone 3 — Decorator: Build-Your-Own Drink Pricing

## Design

`Beverage` is the abstract component (`Espresso`, `Drip`, and the new
`ColdBrew`). `CondimentDecorator` extends `Beverage` and wraps another
`Beverage`, so decorators can be stacked arbitrarily deep — each one
just calls into the beverage it wraps before adding its own cost and
description text. Two new condiments were added: `OatMilk` and
`VanillaSyrup`, alongside the reused `ExtraShot` and `Whip`.

`Main` stacks four condiments on a `ColdBrew`
(`ColdBrew -> OatMilk -> VanillaSyrup -> ExtraShot -> Whip`) and prints
both `cost()` (each decorator adds its price on top of the one it
wraps, so the total is the sum of every layer) and `getDescription()`
(each decorator appends its own text *after* calling into the wrapped
beverage's description, so the string comes out in the exact order the
condiments were added).

## What this makes easy that subclassing wouldn't

Subclassing every combination would need a class per *combination*, not
per condiment — 4 condiments alone gives 2⁴ = 16 possible combinations,
and every new condiment doubles that. With Decorator, adding condiment
#5 is one new ~15-line class, and every existing combination
automatically supports it — nothing else in the hierarchy has to
change or be regenerated.

## Run

```
javac milestone3_decorator/*.java
java milestone3_decorator.Main
```
