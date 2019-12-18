package exam.project;

import exam.project.IShippingCareStrategy.IShippingCareStrategy;
import exam.project.IShippingTypeStrategy.IShippingTypeStrategy;
import exam.project.Products.ElectronicsProduct;

import java.util.ArrayList;

public class Order {

    private ArrayList<ElectronicsProduct> items = new ArrayList<>();
    private IShippingTypeStrategy shippingTypeStrategy;
    private IShippingCareStrategy shippingCareStrategy;
    private Integer distance;

    public Order(ArrayList<ElectronicsProduct> items, IShippingTypeStrategy shippingTypeStrategy,
                 IShippingCareStrategy shippingCareStrategy, Integer distance) {
        this.items = items;
        this.shippingTypeStrategy = shippingTypeStrategy;
        this.shippingCareStrategy = shippingCareStrategy;
        this.distance = distance;
    }

    public Order() {}

    public ArrayList<ElectronicsProduct> getItems() {
        return items;
    }

    public void setItems(ArrayList<ElectronicsProduct> items) {
        this.items = items;
    }

    public IShippingTypeStrategy getShippingTypeStrategy() {
        return shippingTypeStrategy;
    }

    public void setShippingTypeStrategy(IShippingTypeStrategy shippingTypeStrategy) {
        this.shippingTypeStrategy = shippingTypeStrategy;
    }

    public IShippingCareStrategy getShippingCareStrategy() {
        return shippingCareStrategy;
    }

    public void setShippingCareStrategy(IShippingCareStrategy shippingCareStrategy) {
        this.shippingCareStrategy = shippingCareStrategy;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
