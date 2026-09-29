# Milestone 5 — Singleton: One Central Order Ledger

## Design

`OrderLedger` has a `private` constructor and a static
`getInstance()`. The chosen thread-safety fix is **double-checked
locking**: `getInstance()` reads the `volatile instance` field once
with no lock; only if it's `null` does it enter a `synchronized` block,
and *then* checks again before constructing, since another thread could
have finished constructing it between the first check and acquiring
the lock. `volatile` is required here, not optional — without it the
Java Memory Model allows another thread to see a half-constructed
`OrderLedger` through a reordered write.

`Main` spins up 8 threads (standing in for 8 hubs' checkout threads),
each calling `getInstance()` once and then recording 1000 transactions.
It confirms every thread got back the identical object reference, and
that the final transaction count and revenue total match what 8,000
uncontended recordings should produce — which double-checked locking
guarantees precisely because `recordTransaction` is also `synchronized`.

## Why double-checked locking, given the call frequency

`getInstance()` is called constantly (every checkout, on every hub's
thread, for as long as the service runs), but the actual construction
only ever needs to happen once. Plain `synchronized` on `getInstance()`
would force every single call through a lock for the entire lifetime of
the service, even though 99.999...% of those calls are just reading an
already-built object — that's needless contention on the hottest path
in the system. Eager initialization (`static OrderLedger instance = new
OrderLedger();`) is thread-safe and simpler, but it builds the ledger
at class-load time whether or not it's ever needed and offers no
control over *when* construction happens; for a class this cheap to
build that's a fairly minor downside, but double-checked locking gets
the same lazy-init benefit *and* keeps the common-case read lock-free,
which matters more given how often `getInstance()` is called compared
to how rarely it actually needs to do work.

## Bonus: what goes wrong without Singleton

If `OrderLedger` could be instantiated freely, it's easy for two hubs
(or two threads, or a retry path) to each end up holding their own
`OrderLedger` instance. Every `recordTransaction()` call would still
work fine in isolation, but the two instances would silently diverge —
each thinking it holds *the* complete transaction history, when really
each has only half of it. Accounting reconciliation would then
undercount total revenue by however much landed in whichever instance
didn't get read at report time, with no exception, crash, or warning to
signal that anything was wrong.

## Run

```
javac milestone5_singleton/*.java
java milestone5_singleton.Main
```
