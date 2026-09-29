# Milestone 1 — Strategy: Pricing & Loyalty Strategies

## Design

`PricingStrategy` declares one method, `calculateTotal(double subtotal)`.
Four concrete strategies implement it: `NoDiscountStrategy`,
`StudentDiscountStrategy`, `HappyHourStrategy`, and
`LoyaltyTierStrategy` (which is parameterized by a `Tier` enum so bronze/
silver/gold all reuse the same class instead of needing three more
classes).

`Order` holds a `PricingStrategy` reference and delegates
`getTotal()` straight to it. `setPricingStrategy()` lets the strategy be
swapped on an existing `Order` at any time — that's how a loyalty-tier
upgrade mid-session is handled: the order object doesn't change, only
the strategy it's holding does.

## Why not just an if/else chain?

An if/else chain inside `Order` means `Order` has to know about every
discount rule that exists, and every time BrewHub adds a new promotion
someone has to reopen and re-test that same growing method — that's a
direct violation of "classes should be open for extension but closed
for modification." It also means `Order` is doing two jobs (managing
order state, and knowing pricing rules), which makes it harder to unit
test pricing logic in isolation. With Strategy, each discount rule is
its own small, independently testable class, and adding rule #5 means
writing one new file — zero lines change inside `Order`.

## Run

```
javac milestone1_strategy/*.java
java milestone1_strategy.Main
```
