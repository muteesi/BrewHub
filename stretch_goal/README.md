# Stretch Goal — Wiring Milestone 2 and Milestone 5 Together

`LedgerObserver` implements Milestone 2's `Observer` interface and
holds a reference to Milestone 5's `OrderLedger` singleton. It's
registered on the `OrderStatusPublisher` like any other observer, but
only calls `OrderLedger.getInstance().recordTransaction(...)` when an
order's status becomes `READY` — QUEUED and BREWING transitions are
ignored, so a sale is recorded exactly once, at the moment it's
actually final, no matter how many other status changes happened
first.

This keeps the two milestones decoupled: `OrderLedger` never imports
anything from the Observer pattern, and `OrderStatusPublisher` never
imports anything from Singleton. The adapter is the only class that
knows about both.

## Run

Compile the whole project together so packages resolve:

```
javac -d out $(find . -name "*.java")
java -cp out stretch_goal.Main
```
