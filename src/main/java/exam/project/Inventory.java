package exam.project;

import exam.project.Products.DesignerRadio;
import exam.project.Products.DiscountTV;
import exam.project.Products.ElectronicsProduct;

import java.util.ArrayList;

public class Inventory {
    private volatile static Inventory instance;

    private ArrayList<IInventoryObserver> inventoryObservers = new ArrayList<>();
    private ArrayList<ElectronicsProduct> electronicsProducts = new ArrayList<>();

    private Inventory(){
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
        }

        insertMockData();
    }

    // Singleton proofing
    public static Inventory getInstance() {
        // Lazy-initialization
        if (instance == null) {
            // Thread-safe
            synchronized (Inventory.class) {
                if (instance == null) {
                    instance = new Inventory();
                }
            }
        }
        return instance;
    }

    private void insertMockData() {
        electronicsProducts.add(new DesignerRadio());
        electronicsProducts.add(new DesignerRadio());
        electronicsProducts.add(new DiscountTV());
        electronicsProducts.add(new DesignerRadio());
        electronicsProducts.add(new DesignerRadio());
        electronicsProducts.add(new DiscountTV());
    }

    public void addObserver(IInventoryObserver observer){
        inventoryObservers.add(observer);
    }

    public void notifyObservers(){
        for(IInventoryObserver observer: inventoryObservers){
            observer.inventoryUpdate(this);
        }
    }

    public void addProducts(ArrayList<ElectronicsProduct> products) {
        electronicsProducts.addAll(products);
        notifyObservers();
    }

    public void removeProducts(ArrayList<ElectronicsProduct> products) {
        electronicsProducts.removeAll(products);
    }

    public ArrayList<ElectronicsProduct> getElectronicsProducts() {
        return electronicsProducts;
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
