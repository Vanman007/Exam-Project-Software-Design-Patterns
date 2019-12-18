package exam.project;

import java.util.ArrayList;

public class OrderBook {

    private volatile static OrderBook instance;

    private ArrayList<IOrderBookObserver> orderBookObservers = new ArrayList<>();
    private ArrayList<Order> orderBook;

    private OrderBook(){
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
        }
    }

    // Singleton proofing
    public static OrderBook getInstance() {
        // Lazy-initialization
        if (instance == null) {
            // Thread-safe
            synchronized (OrderBook.class) {
                if (instance == null) {
                    instance = new OrderBook();
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

    public ArrayList<Order> getOrderBook() {
        return orderBook;
    }

    public void addOrder(Order order) {
        orderBook.add(order);
        notifyObservers();
        System.out.println("An order was added to the order book!");
    }

    public void removeOrder(Order order) {
        orderBook.remove(order);
        notifyObservers();
        System.out.println("An order was deleted from the order book!");
    }

    public void addObserver(IOrderBookObserver observer){
        orderBookObservers.add(observer);
    }

    public void notifyObservers(){
        for(IOrderBookObserver observer: orderBookObservers){
            observer.orderBookUpdate(this);
        }
    }

}
