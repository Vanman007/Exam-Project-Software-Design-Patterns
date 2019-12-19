package exam.project;

import exam.project.IShippingCareStrategy.CarefulShippingCareStrategy;
import exam.project.IShippingCareStrategy.HaphazardShippingCareStrategy;
import exam.project.IShippingTypeStrategy.AirStandardTypeStrategy;
import exam.project.IShippingTypeStrategy.TruckTypeStrategy;
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
            throw new RuntimeException("\nUse getInstance() method instead.\n");
        }

        insertMockData();
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

    private void insertMockData() {
        ArrayList<ElectronicsProduct> tempItems = new ArrayList<>();
        tempItems.add(new DesignerRadio());
        tempItems.add(new DesignerRadio());
        tempItems.add(new DiscountTV());
        orderBook.add(new Order(tempItems, new AirStandardTypeStrategy(), new CarefulShippingCareStrategy(), 200));
        tempItems = new ArrayList<>();
        tempItems.add(new DesignerRadio());
        tempItems.add(new DesignerRadio());
        tempItems.add(new DesignerRadio());
        orderBook.add(new Order(tempItems, new TruckTypeStrategy(), new HaphazardShippingCareStrategy(), 200));
    }

    public ArrayList<Order> getOrderBook() {
        return orderBook;
    }

    public void addOrder(Order order) {
        orderBook.add(order);
        System.out.println("\nAn order was added to the order book!\n");
        notifyObservers();
    }

    public void removeOrders(ArrayList<Order> orders) {
        orderBook.removeAll(orders);
        System.out.println("\n" + orders.size() + " order(s) were removed from the order book after shipping!\n");
    }

    public void addObserver(IOrderBookObserver observer){
        orderBookObservers.add(observer);
    }

    public void notifyObservers(){
        for(IOrderBookObserver observer: orderBookObservers){
            observer.orderBookUpdate(this);
        }
    }

    // Clone-safe
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("\nDon't clone the singleton.\n");
    }

    // Serialization-safe
    protected Object readResolve() {
        return getInstance();
    }
}
