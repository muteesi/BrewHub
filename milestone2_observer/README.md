# Milestone 2 — Observer: Live Order & Inventory Dashboards

## Design

`Subject` (register/remove/notify) is implemented by
`OrderStatusPublisher`, which holds the currently-changing `Order` and
the list of subscribed `Observer`s. `KitchenDisplay`, `CustomerNotifier`,
and `InventoryTracker` each implement `Observer` and react differently
to the same event — the kitchen display logs every transition, the
customer notifier only fires on READY, and the inventory tracker only
fires on BREWING. `OrderService` (represented here by `Main`, standing
in for whatever drives order state) never references any of the three
concrete observer classes — it only knows about the `Subject` interface,
so adding a fourth dashboard later means writing one new class and
calling `registerObserver()`, with zero changes to the publisher.

Subscribing/unsubscribing at runtime is shown in `Main`:
`InventoryTracker` is removed mid-run and stops receiving updates.

## Push vs. Pull

This design uses **pull**: `update(OrderStatusPublisher publisher)`
hands the observer a reference to the subject, and the observer calls
`publisher.getCurrentOrder()` to get only the data it needs.

Push (`update(String orderId, Status status)`) was considered, but
pull is the better fit here because the three observers want
meaningfully different slices of order data (today just status, but a
future observer — say, a receipt printer — might need pricing or line
items too). With push, every future data need means widening the
`update()` signature and touching every existing observer. With pull,
adding a new observer that needs order total or line items costs
nothing on the `Subject` or `Observer` interfaces — it just calls
another getter on the `Order`/`Publisher` it already has a handle to.

## Run

```
javac milestone2_observer/*.java
java milestone2_observer.Main
```
