package exam.project;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean runApplication = true;

        while(runApplication) {
            boolean selectedCommand = false;

            System.out.println("Enter number:");
            System.out.println("1: Increment stock of product");
            System.out.println("2: Create shipping order");

            String command = input.next();
            switch (command) {
                case "1":
                    System.out.println("Increment stock");
                    selectedCommand = true;
                    break;
                case "2":
                    System.out.println("Create order");
                    selectedCommand = true;
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    runApplication = false;
                    break;
                default:
                    System.out.println("No command found");
                    break;
            }

            while(selectedCommand && runApplication) {
                switch (command) {
                    case "1":
                        System.out.println("Enter type:");
                        System.out.println("1: TV");
                        System.out.println("2: Radio");
                        break;
                    case "2":
                        System.out.println("TODO");
                        break;
                }

                String productType = input.next();
                if ("x".equals(productType)) {
                    selectedCommand = false;
                } else {
                    boolean tierTypeSelected = false;

                    System.out.println("Enter tier:");
                    System.out.println("1: Low-tier");
                    System.out.println("2: Mid-tier");
                    System.out.println("3: High-tier");

                    while (!tierTypeSelected && runApplication) {
                        String tierType = input.next();
                        switch (tierType) {
                            case "1":
                                System.out.println("Selected low-tier");
                                tierTypeSelected = true;
                                break;
                            case "2":
                                System.out.println("Selected mid-tier");
                                tierTypeSelected = true;
                                break;
                            case "3":
                                System.out.println("Selected high-tier");
                                tierTypeSelected = true;
                                break;
                            case "exit":
                                System.out.println("Exiting...");
                                runApplication = false;
                                break;
                            default:
                                System.out.println("No command found");
                                break;
                        }
                    }
                }
            }
        }

        /*
        ShippingManager manager = ShippingManager.getInstance();
        ISubscriber inventory = new Inventory();
        ISubscriber smsService = new SMSService();
        ISubscriber emailService = new EmailService();

        manager.subscribe(inventory);
        manager.subscribe(smsService);
        manager.subscribe(emailService);

        manager.ship();*/
    }
}
