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

    public void addProduct(ElectronicsProduct electronicsProduct, String type) {

        switch (type){
            case "Discount TV":
                discountTVs.add((DiscountTV)electronicsProduct);
            break;
            case "Discount Radio":
                discountRadios.add((DiscountRadio) electronicsProduct);
            break;
            case "MidEnd TV":
                midEndTVs.add((MidEndTV) electronicsProduct);
            break;
            case "MidEnd Radio":
                midEndRadios.add((MidEndRadio) electronicsProduct);
            break;
            case "Designer TV":
                designerTVs.add((DesignerTV) electronicsProduct);
            break;
            case "Designer Radio":
                designerRadios.add((DesignerRadio) electronicsProduct);
            break;
            default:
                System.out.println("ERROR!");
            break;
        }

    }

    public void removeProduct(String type){
        switch (type){
            case "Discount TV":
                discountTVs.remove(0);
                break;
            case "Discount Radio":
                discountRadios.remove(0);
                break;
            case "MidEnd TV":
                midEndTVs.remove(0);
                break;
            case "MidEnd Radio":
                midEndRadios.remove(0);
                break;
            case "Designer TV":
                designerTVs.remove(0);
                break;
            case "Designer Radio":
                designerRadios.remove(0);
                break;
            default:
                System.out.println("ERROR!");
                break;
        }

    }

    @Override
    public void update(Order order) {
        System.out.println("Update on Inventory");

    }
}
