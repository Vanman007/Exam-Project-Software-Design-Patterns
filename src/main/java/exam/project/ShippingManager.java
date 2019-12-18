package exam.project;

import exam.project.Products.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShippingManager implements IInventoryObserver, IOrderBookObserver {

    private volatile static ShippingManager instance;
    private ShipItemCost shipItemCost;
    private Map<String, Integer> currentInventoryStatus;
    private ArrayList<Order> currentOrderStatus;
    public ArrayList<ElectronicsProduct> currentInventory;
    public ArrayList<Order> currentOrders;

//    private ArrayList<ISubscriber> subscribers = new ArrayList<>();

    private ShippingManager() {
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
        }
        Inventory.getInstance().addObserver(this);
        OrderBook.getInstance().addObserver(this);
        currentInventory = Inventory.getInstance().getElectronicsProducts();
        currentOrders = OrderBook.getInstance().getOrderBook();
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
        System.out.println("GOT UPDATE FROM INVENTORY");
        currentInventoryStatus = inventory.getInventoryState();
        currentInventory = inventory.getElectronicsProducts();
        checkIfShippable();
        //checkIfOrderShippable();
    }

    @Override
    public void orderBookUpdate(OrderBook orderBook) {
        System.out.println("GOT UPDATE FROM ORDER BOOK");
        currentOrderStatus = orderBook.getOrderBook();
        checkIfOrderShippable();
    }

    public void checkIfOrderShippable(){
        for(Order order: currentOrderStatus){
            ArrayList<ElectronicsProduct> itemList = order.getItems();
            Inventory inventory = Inventory.getInstance();
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
                        if(mapEntry.getKey().equals("DiscountTV")){
                            for(int i = 0; i<mapEntry.getValue(); i++){
                                inventory.removeProduct(new DiscountTV());
                            }
                        } else if(mapEntry.getKey().equals("DiscountRadio")){
                            for(int i = 0; i<mapEntry.getValue(); i++){
                                inventory.removeProduct(new DiscountRadio());
                            }
                        } else if(mapEntry.getKey().equals("MidEndTV")){
                            for(int i = 0; i<mapEntry.getValue(); i++){
                                inventory.removeProduct(new MidEndTV());
                            }
                        } else if(mapEntry.getKey().equals("MidEndRadio")){
                            for(int i = 0; i<mapEntry.getValue(); i++){
                                inventory.removeProduct(new MidEndRadio());
                            }
                        } else if(mapEntry.getKey().equals("DesignerTV")){
                            for(int i = 0; i<mapEntry.getValue(); i++){
                                inventory.removeProduct(new DesignerTV());
                            }
                        } else if(mapEntry.getKey().equals("DesignerTV")){
                            for(int i = 0; i<mapEntry.getValue(); i++){
                                inventory.removeProduct(new DesignerRadio());
                            }
                        }
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

    public void checkIfShippable() {
        // Jakob Larsen kode
        if (currentOrders != null && currentOrders.size() > 0) {
            // Loop over each order in the order book
            for (int i = 0; i < currentOrders.size(); i++) {
                Order currentOrder = currentOrders.get(i);
                if (currentOrder.getItems() != null && currentOrder.getItems().size() > 0) {
                    // Create map to store needed quantities for each product type
                    Map<String, Integer> productQuantities = new HashMap<>();
                    for (int j = 0; j < currentOrder.getItems().size(); j++) {
                        ElectronicsProduct product = currentOrder.getItems().get(j);
                        String productName = product.getClass().getSimpleName();
                        if (!productQuantities.containsKey(productName)) {
                            productQuantities.put(productName, 1);
                        } else {
                            int currentQuantity = productQuantities.get(productName);
                            productQuantities.replace(productName, currentQuantity + 1);
                        }
                    }
                    int productNeeded = productQuantities.size();
                    int productsFound = 0;
                    ArrayList<ElectronicsProduct> electronicsProducts = new ArrayList<>();
                    // For each product in the order, get the quantity for each product needed for the order
                    for (String name : productQuantities.keySet()) {
                        int quantityNeeded = productQuantities.get(name);
                        int quantityFound = 0;

                        // For each product in the inventory, check if there's the required quantity needed in the order
                        for (int j = 0; j < currentInventory.size(); j++) {
                            ElectronicsProduct product = currentInventory.get(j);
                            // If the product needed is found, increment the quantities found, and add the
                            // ID of the product so it's easier to remove later on
                            // Also, only add it if we haven't already found the required amount
                            if (product.getClass().getSimpleName().equals(name) && quantityFound != quantityNeeded) {
                                electronicsProducts.add(product);
                                quantityFound += 1;
                            }
                        }
                        // If the quantities are found, the product is in stock in the right amount of quantity
                        // (But we still need to check the other products in the order)
                        if (quantityFound >= quantityNeeded) {
                            productsFound += 1;
                        } else {
                            // If the quantities aren't found, reset the IDs for deleted.
                            electronicsProducts = new ArrayList<>();
                        }
                    }

                    // If there's the required quantity for each product, the order can be completed.
                    // We need to remove the products from the inventory, to account for the next order (avoid double booking)
                    if (productsFound >= productNeeded) {
                        System.out.println("Order could be created.");
                        // TODO: Notify ShipItem
                        if (electronicsProducts.size() > 0) {
                            for (ElectronicsProduct electronicsProduct : electronicsProducts) {
                                System.out.println(currentInventory.toString());
                                currentInventory.remove(electronicsProduct);
                                System.out.println(currentInventory.toString());
                            }
                            currentInventory.trimToSize();
                        }
                    } else {
                        // If there isn't the required quantity for each product,
                        // the order can't be fulfilled - move on to the next order
                        System.out.println("Order could not be created due to lack of stock.");
                    }

                    System.out.println(currentInventory.toString());
                }
            }
        }

    }
}
