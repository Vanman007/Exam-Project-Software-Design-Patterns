package exam.project;

import exam.project.IShippingCareStrategy.IShippingCareStrategy;
import exam.project.IShippingTypeStrategy.IShippingTypeStrategy;
import exam.project.Products.ElectronicsProduct;

import java.util.ArrayList;

public class Order {

    private ArrayList<ElectronicsProduct> items;
    private IShippingTypeStrategy iShippingTypeStrategy;
    private IShippingCareStrategy iShippingCareStrategy;
    private String email;
    private String phoneNumber;

    public Order(ArrayList<ElectronicsProduct> items, IShippingTypeStrategy iShippingTypeStrategy,
                 IShippingCareStrategy iShippingCareStrategy, String email, String phoneNumber) {
        this.items = items;
        this.iShippingTypeStrategy = iShippingTypeStrategy;
        this.iShippingCareStrategy = iShippingCareStrategy;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
