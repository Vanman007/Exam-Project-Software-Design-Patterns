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

    }

    @Override
    public void update(Order order) {
        System.out.println("Update on Inventory");
    }

}
