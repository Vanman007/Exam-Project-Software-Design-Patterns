package exam.project;

import java.util.ArrayList;

public class OrderBook {

    private ArrayList<Order> orderBook;

    public void addOrder(Order order) {
        orderBook.add(order);
        System.out.println("An order was added to the order book!");
    }

    public void removeOrder(Order order) {
        orderBook.remove(order);
        System.out.println("An order was deleted from the order book!");
    }

}
