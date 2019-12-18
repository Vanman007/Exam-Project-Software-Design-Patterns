package exam.project;

import java.util.ArrayList;

public class ShippingManager {
    private volatile static ShippingManager instance;
    private ShipItemCost shipItemCost;
    private ArrayList<ISubscriber> subscribers = new ArrayList<>();

    private ShippingManager() {
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
        }
    }

    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Order order) {
        for (ISubscriber subscriber: subscribers ) {
            subscriber.update(order);
        }
    }

    public void ship(Order order) {
        notifySubscribers(order);
    }

    // Singleton proofing
    static ShippingManager getInstance() {
        // Lazy-initialization
        if (instance == null) {
            // Thread-safe
            synchronized (ShippingManager.class) {
                if (instance == null) {
                    instance = new ShippingManager();
                }
            }
        }
        return instance;
    }

    // Clone-safe
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Don't clone the singleton.");
    }

    // Serialization-safe
    protected Object readResolve() {
        return getInstance();
    }
}
