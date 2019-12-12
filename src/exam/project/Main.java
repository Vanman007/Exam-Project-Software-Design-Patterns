package exam.project;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Date date = new Date();

        System.out.println("Enter number:");
        System.out.println("1: Create new product");
        System.out.println("2: Edit existing product");
        System.out.println("3: Delete product");
        System.out.println("4: Receive product(s)");
        System.out.println("5: Ship product(s)");

        ShippingManager manager = ShippingManager.getInstance();
        ISubscriber inventory = new Inventory();
        ISubscriber smsService = new SMSService();
        ISubscriber emailService = new EmailService();

        manager.subscribe(inventory);
        manager.subscribe(smsService);
        manager.subscribe(emailService);

        manager.ship();
    }
}
