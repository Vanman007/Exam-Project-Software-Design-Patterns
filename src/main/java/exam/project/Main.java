package exam.project;

import exam.project.Products.ElectronicsProduct;

import java.util.ArrayList;
import java.util.Scanner;

enum MenuState {
    OPTION_SELECTION,
    ADD_PRODUCT,
    SHIP_ORDER,
    EXITING
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean runApplication = true;
        MenuState menuState = MenuState.OPTION_SELECTION;

        while (runApplication) {
            while (menuState == MenuState.OPTION_SELECTION) {
                Menu.printMenu(MenuState.OPTION_SELECTION);
                MenuState optionSelection = Menu.getOptionState(MenuState.OPTION_SELECTION, input.next());
                if (optionSelection == MenuState.OPTION_SELECTION) {
                    System.out.println("Invalid command.");
                } else {
                    menuState = optionSelection;
                }
            }

<<<<<<< HEAD
            System.out.println("Enter number:");
            System.out.println("1: Increment stock of product");
            System.out.println("2: Create shipping order");

            String command =  "1";
            // input.next();
            switch (command) {
                case "1":
                    System.out.println("Increment stock");
                    selectedCommand = true;
                    break;
                case "2":
                    System.out.println("Create order");
                    selectedCommand = true;
=======
            while (menuState == MenuState.ADD_PRODUCT) {
                Menu.printMenu(MenuState.ADD_PRODUCT);
                String productToAdd = Menu.getProductFromSelection(input.next());
                if (productToAdd == null) {
                    System.out.println("-----------");
                    System.out.println("Invalid command. Try again:");
                } else {
                    System.out.println("How many to add to stock?");
                    int stockIncrease = Menu.getNumberFromInput(input.next());
                    Menu.addStock(stockIncrease, productToAdd);
                    menuState = MenuState.OPTION_SELECTION;
                }
            }

            while (menuState == MenuState.SHIP_ORDER) {
                ArrayList<ElectronicsProduct> products = new ArrayList<>();
                Menu.printMenu((MenuState.SHIP_ORDER));
                String command = input.next();
                if (command.equals("exit")) {
                    menuState = MenuState.EXITING;
>>>>>>> b6de56e2ecd93d41113ebd0301a05e2c1e43dd09
                    break;
                } else if (command.equals("7")) {
                    Menu.shipIt();
                    menuState = MenuState.OPTION_SELECTION;
                    break;
<<<<<<< HEAD
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
=======
>>>>>>> b6de56e2ecd93d41113ebd0301a05e2c1e43dd09
                }
                String productToPurchase = Menu.getProductFromSelection(command);
                if (productToPurchase == null) {
                    System.out.println("-----------");
                    System.out.println("Invalid command. Try again:");
                } else {
<<<<<<< HEAD
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
=======
                    System.out.println("How many to add to stock?");
                    String commandSelection = input.next();
                    int numberOfProducts = Menu.getNumberFromInput(commandSelection);
                    Menu.addToOrder(numberOfProducts, productToPurchase, products);
                    //Order newOrder = new Order();
>>>>>>> b6de56e2ecd93d41113ebd0301a05e2c1e43dd09
                }
            }
        }
    }
}
