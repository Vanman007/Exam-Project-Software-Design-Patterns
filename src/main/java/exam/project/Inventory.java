package exam.project;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory implements ISubscriber {

    //private HashMap<ElectronicsProduct> products = new HashMap();
    private ArrayList<DiscountRadio> discountRadios = new ArrayList<>();
    private ArrayList<MidEndRadio> midEndRadios = new ArrayList<>();
    private ArrayList<DesignerRadio> designerRadios = new ArrayList<>();

    private ArrayList<DiscountTV> discountTVs = new ArrayList<>();
    private ArrayList<MidEndTV> midEndTVs = new ArrayList<>();
    private ArrayList<DesignerTV> designerTVs = new ArrayList<>();

    public void addProduct(String type) {

    }

    public void removeProduct(String type){

    }

    @Override
    public void update() {
        System.out.println("Update on Inventory");
    }

    public void decrementStock(String type) {

    }
}
