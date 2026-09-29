package milestone2_observer;

/** Standard Subject contract: register, remove, notify. */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
