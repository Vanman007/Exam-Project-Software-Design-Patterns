package exam.project;

import exam.project.Products.DesignerRadio;
import exam.project.Products.DiscountTV;
import exam.project.Products.ElectronicsProduct;

import java.util.ArrayList;

public class OrderBook {

    private volatile static OrderBook instance;

    private ArrayList<IOrderBookObserver> orderBookObservers = new ArrayList<>();
    private ArrayList<Order> orderBook = new ArrayList<>();

    private OrderBook(){
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
        }

        Order tempOrder = new Order();
        ArrayList<ElectronicsProduct> tempItems = new ArrayList<>();
        tempItems.add(new DesignerRadio());
        tempItems.add(new DesignerRadio());
        tempItems.add(new DiscountTV());
        tempOrder.setItems(tempItems);
        Order secondTempOrder = new Order();
        ArrayList<ElectronicsProduct>  secondTempItems = new ArrayList<>();
        tempItems.add(new DesignerRadio());
        tempItems.add(new DesignerRadio());
        secondTempOrder.setItems(secondTempItems);
        orderBook.add(tempOrder);
        orderBook.add(secondTempOrder);
        System.out.println(orderBook.toString());
        notifyObservers();
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
        System.out.println("An order was added to the order book!");
        orderBook.add(order);
        notifyObservers();
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
