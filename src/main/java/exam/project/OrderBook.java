package exam.project;

import java.util.ArrayList;

public class OrderBook {

    private ArrayList<Order> orderBook;

    public void addOrder(Order order) {
        orderBook.add(order);
    }

    public void removeOrder(Order order) {
        orderBook.remove(order);
    }

}
