package exam.project;

import exam.project.Products.*;
import exam.project.Unused.ISubscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory{

    private volatile static Inventory instance;

    private ArrayList<IInventoryObserver> inventoryObservers = new ArrayList<>();

    private ArrayList<DiscountRadio> discountRadios = new ArrayList<>();
    private ArrayList<MidEndRadio> midEndRadios = new ArrayList<>();
    private ArrayList<DesignerRadio> designerRadios = new ArrayList<>();

    private ArrayList<DiscountTV> discountTVs = new ArrayList<>();
    private ArrayList<MidEndTV> midEndTVs = new ArrayList<>();
    private ArrayList<DesignerTV> designerTVs = new ArrayList<>();

    private Inventory(){
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
        }
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

    // Clone-safe
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Don't clone the singleton.");
    }

    // Serialization-safe
    protected Object readResolve() {
        return getInstance();
    }

    public void addObserver(IInventoryObserver observer){
        inventoryObservers.add(observer);
    }

    public void notifyObservers(){
        for(IInventoryObserver observer: inventoryObservers){
            observer.inventoryUpdate(this);
        }
    }

    public void addProduct(ElectronicsProduct electronicsProduct) {

        switch (electronicsProduct.getClass().getSimpleName()){
            case "DiscountTV":
                discountTVs.add((DiscountTV)electronicsProduct);
            break;
            case "DiscountRadio":
                discountRadios.add((DiscountRadio) electronicsProduct);
            break;
            case "MidEndTV":
                midEndTVs.add((MidEndTV) electronicsProduct);
            break;
            case "MidEndRadio":
                midEndRadios.add((MidEndRadio) electronicsProduct);
            break;
            case "DesignerTV":
                designerTVs.add((DesignerTV) electronicsProduct);
            break;
            case "DesignerRadio":
                designerRadios.add((DesignerRadio) electronicsProduct);
            break;
            default:
                System.out.println("ERROR!");
            break;
        }

        notifyObservers();

    }

    public void removeProduct(ElectronicsProduct electronicsProduct){
        switch (electronicsProduct.getClass().getSimpleName()){
            case "DiscountTV":
                discountTVs.remove(0);
                break;
            case "DiscountRadio":
                discountRadios.remove(0);
                break;
            case "MidEndTV":
                midEndTVs.remove(0);
                break;
            case "MidEndRadio":
                midEndRadios.remove(0);
                break;
            case "DesignerTV":
                designerTVs.remove(0);
                break;
            case "DesignerRadio":
                designerRadios.remove(0);
                break;
            default:
                System.out.println("ERROR!");
                break;
        }

        notifyObservers();

    }


    public Map<String,Integer> getInventoryState(){

        Map<String,Integer> inventoryMap = new HashMap<>();

        for(DiscountTV discountTV: discountTVs){
            if(!inventoryMap.containsKey(discountTV.getClass().getSimpleName())){
                inventoryMap.put(discountTV.getClass().getSimpleName(),1);
            } else{
                inventoryMap.put(discountTV.getClass().getSimpleName(), inventoryMap.get(discountTV.getClass().getSimpleName()) + 1);
            }
        }

        for(DiscountRadio discountRadio: discountRadios){
            if(!inventoryMap.containsKey(discountRadio.getClass().getSimpleName())){
                inventoryMap.put(discountRadio.getClass().getSimpleName(),1);
            } else{
                inventoryMap.put(discountRadio.getClass().getSimpleName(), inventoryMap.get(discountRadio.getClass().getSimpleName()) + 1);
            }
        }

        for(MidEndTV midEndTV: midEndTVs){
            if(!inventoryMap.containsKey(midEndTV.getClass().getSimpleName())){
                inventoryMap.put(midEndTV.getClass().getSimpleName(),1);
            } else{
                inventoryMap.put(midEndTV.getClass().getSimpleName(), inventoryMap.get(midEndTV.getClass().getSimpleName()) + 1);
            }
        }

        for(MidEndRadio midEndRadio: midEndRadios){
            if(!inventoryMap.containsKey(midEndRadio.getClass().getSimpleName())){
                inventoryMap.put(midEndRadio.getClass().getSimpleName(),1);
            } else{
                inventoryMap.put(midEndRadio.getClass().getSimpleName(), inventoryMap.get(midEndRadio.getClass().getSimpleName()) + 1);
            }
        }

        for(DesignerTV designerTV: designerTVs){
            if(!inventoryMap.containsKey(designerTV.getClass().getSimpleName())){
                inventoryMap.put(designerTV.getClass().getSimpleName(),1);
            } else{
                inventoryMap.put(designerTV.getClass().getSimpleName(), inventoryMap.get(designerTV.getClass().getSimpleName()) + 1);
            }
        }

        for(DesignerRadio designerRadio: designerRadios){
            if(!inventoryMap.containsKey(designerRadio.getClass().getSimpleName())){
                inventoryMap.put(designerRadio.getClass().getSimpleName(),1);
            } else{
                inventoryMap.put(designerRadio.getClass().getSimpleName(), inventoryMap.get(designerRadio.getClass().getSimpleName()) + 1);
            }
        }

        return inventoryMap;

    }

}
