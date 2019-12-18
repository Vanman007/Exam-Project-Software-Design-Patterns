package exam.project;

import exam.project.IShippingCareStrategy.IShippingCareStrategy;
import exam.project.IShippingTypeStrategy.IShippingTypeStrategy;
import exam.project.Products.ElectronicsProduct;

import java.util.ArrayList;

public class TEMP_Order {
    ArrayList<ElectronicsProduct> products = new ArrayList<>();
    IShippingCareStrategy careStrategy;
    IShippingTypeStrategy typeStrategy;
    int distance;

    public TEMP_Order() {

    }

    public TEMP_Order(ArrayList<ElectronicsProduct> products, IShippingCareStrategy careStrategy, IShippingTypeStrategy typeStrategy) {
        this.products = products;
        this.careStrategy = careStrategy;
        this.typeStrategy = typeStrategy;
    }
}
