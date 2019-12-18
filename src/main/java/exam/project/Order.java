package exam.project;

import exam.project.IShippingCareStrategy.IShippingCareStrategy;
import exam.project.IShippingTypeStrategy.IShippingTypeStrategy;
import exam.project.Products.ElectronicsProduct;

import java.util.ArrayList;

public class Order {

    private ArrayList<ElectronicsProduct> items;
    private IShippingTypeStrategy shippingTypeStrategy;
    private IShippingCareStrategy shippingCareStrategy;

    public Order(ArrayList<ElectronicsProduct> items, IShippingTypeStrategy shippingTypeStrategy,
                 IShippingCareStrategy shippingCareStrategy) {
        this.items = items;
        this.shippingTypeStrategy = shippingTypeStrategy;
        this.shippingCareStrategy = shippingCareStrategy;
    }
}
