package exam.project;

import exam.project.Products.ElectronicsProduct;
import exam.project.Unused.ISubscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShippingManager implements IInventoryObserver, IOrderBookObserver {

    private volatile static ShippingManager instance;
    private ShipItemCost shipItemCost;
    private Map<String, Integer> currentInventoryStatus;
    private ArrayList<Order> currentOrderStatus;

//    private ArrayList<ISubscriber> subscribers = new ArrayList<>();

    private ShippingManager() {
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
        }
    }

    // Singleton proofing
    public static ShippingManager getInstance() {
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

    @Override
    public void inventoryUpdate(Inventory inventory) {
        currentInventoryStatus = inventory.getInventoryState();
        checkIfOrderShippable();
    }

    @Override
    public void orderBookUpdate(OrderBook orderBook) {
        currentOrderStatus = orderBook.getOrderBook();
        checkIfOrderShippable();
    }

    public void checkIfOrderShippable(){
        for(Order order: currentOrderStatus){
            ArrayList<ElectronicsProduct> itemList = order.getItems();
            Map<String,Integer> tempMap = new HashMap<>();
            

            for(ElectronicsProduct electronicsProduct: itemList){
                if(currentInventoryStatus.containsKey(electronicsProduct.getClass().getSimpleName())){
                    if(!tempMap.containsKey(electronicsProduct.getClass().getSimpleName())){
                        tempMap.put(electronicsProduct.getClass().getSimpleName(),1);
                    } else{
                        tempMap.put(electronicsProduct.getClass().getSimpleName(), tempMap.get(electronicsProduct.getClass().getSimpleName()) + 1);
                    }
                }
            }

            for(Map.Entry<String, Integer> mapEntry: tempMap.entrySet()){
                if(currentInventoryStatus.containsKey(mapEntry.getKey())){
                    if((currentInventoryStatus.get(mapEntry.getKey()) - mapEntry.getValue()) >= 0){

                    }
                }
            }

        }
    }

//    public void subscribe(ISubscriber subscriber) {
//        subscribers.add(subscriber);
//    }
//    public void unsubscribe(ISubscriber subscriber) {
//        subscribers.remove(subscriber);
//    }

//    public void notifySubscribers(Order order) {
//        for (ISubscriber subscriber: subscribers ) {
//            subscriber.update(order);
//        }
//    }
//
//    public void ship(Order order) {
//        notifySubscribers(order);
//    }

}
