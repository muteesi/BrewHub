# BrewHub — Design Patterns Homework

Five milestones, one growing codebase, each in its own package folder.
Each folder has its own README explaining the design decision for that
milestone; this file just covers how to build/run everything.

```
brewhub/
  milestone1_strategy/     Strategy      — pricing & loyalty discounts
  milestone2_observer/     Observer      — order/inventory dashboards
  milestone3_decorator/    Decorator     — build-your-own drink pricing
  milestone4_factory/      Factory Method + Abstract Factory — regional sourcing
  milestone5_singleton/    Singleton     — central order ledger
  stretch_goal/            Bonus: OrderLedger subscribes to OrderStatusPublisher
```

## Build & run

Each milestone is self-contained and can be compiled on its own:

```
javac milestone1_strategy/*.java
java milestone1_strategy.Main
```

...and so on for milestones 2-5 (swap the package name).

The stretch goal imports classes from both `milestone2_observer` and
`milestone5_singleton`, so it needs the whole project compiled together
with the project root on the classpath:

```
javac -d out $(find . -name "*.java")
java -cp out stretch_goal.Main
```

## A note on compiling

This was written and reviewed without a JDK available (only a JRE was
on hand in the environment I built it in), so I checked it carefully
by hand — package declarations, brace balance, consistent method
signatures against each interface — but I was not able to run `javac`
myself. Compile it as your first step; if anything doesn't build,
paste me the error and I'll fix it immediately.
