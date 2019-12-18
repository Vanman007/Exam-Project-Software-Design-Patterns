package exam.project;

import exam.project.Products.*;

import java.util.ArrayList;

public class Inventory implements ISubscriber {
    //private HashMap<ElectronicsProduct> products = new HashMap();
    private ArrayList<DiscountRadio> discountRadios = new ArrayList<>();
    private ArrayList<MidEndRadio> midEndRadios = new ArrayList<>();
    private ArrayList<DesignerRadio> designerRadios = new ArrayList<>();

    private ArrayList<DiscountTV> discountTVs = new ArrayList<>();
    private ArrayList<MidEndTV> midEndTVs = new ArrayList<>();
    private ArrayList<DesignerTV> designerTVs = new ArrayList<>();

    public void decrementStock(String type) {

    }

    @Override
    public void update(Order order) {
        System.out.println("Update on Inventory");

    }
}
