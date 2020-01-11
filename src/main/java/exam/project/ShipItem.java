package exam.project;

import exam.project.IShippingCareStrategy.IShippingCareStrategy;
import exam.project.IShippingTypeStrategy.IShippingTypeStrategy;

public class ShipItem {

    private IShippingTypeStrategy shippingTypeStrategy;
    private IShippingCareStrategy shippingCareStrategy;

    public ShipItem(IShippingCareStrategy shippingCareStrategy, IShippingTypeStrategy shippingTypeStrategy) {
        this.shippingCareStrategy = shippingCareStrategy;
        this.shippingTypeStrategy = shippingTypeStrategy;
    }

    public IShippingTypeStrategy getIShippingTypeStrategy() {
        return shippingTypeStrategy;
    }

    public IShippingCareStrategy getIShippingCareStrategy() {
        return shippingCareStrategy;
    }

    public void setIShippingTypeStrategy(IShippingTypeStrategy shippingTypeStrategy) {
        this.shippingTypeStrategy = shippingTypeStrategy;
    }

    public void setIShippingCareStrategy(IShippingCareStrategy shippingCareStrategy) {
        this.shippingCareStrategy = shippingCareStrategy;
    }

    // Use shippingTypeStrategy and shippingCareStrategy to calculate cost and return it to client
    public double calculateOrderCost(Order order) {
        double totalCost = 0.0;
        totalCost += shippingTypeStrategy.calculateShippingMultiplier(order.getDistance());
        for (int i = 0; i < order.getItems().size(); i++) {
            totalCost += shippingCareStrategy.calculateShippingCare(
                    order.getItems().get(i).getWeight(), order.getItems().get(i).getSize()
            );
        }
        return totalCost;
    }
}
