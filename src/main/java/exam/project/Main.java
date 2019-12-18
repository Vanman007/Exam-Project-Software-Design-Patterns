package exam.project;

import exam.project.Products.ElectronicsProduct;
import exam.project.Products.IAbstractElectronicsFactory;

import java.util.ArrayList;
import java.util.Scanner;

enum MenuState {
    OPTION_SELECTION,
    ADD_PRODUCT,
    ADD_ORDER,
    EXITING
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner input = new Scanner(System.in);
        boolean runApplication = true;
        MenuState menuState = MenuState.OPTION_SELECTION;

        TEMP_Order order = new TEMP_Order();

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

            while (menuState == MenuState.ADD_PRODUCT) {
                Menu.printMenu(MenuState.ADD_PRODUCT);
                String command = input.next();
                if (command.equals("exit")) {
                    menuState = MenuState.EXITING;
                    break;
                } else if (Menu.isValidInput(command)) {
                    System.out.println("-----------");
                    System.out.println("Invalid command. Try again:");
                } else {
                    System.out.println("How many to add to stock?");
                    int stockIncrease = Menu.getNumberFromInput(input.next());
                    ElectronicsProduct productToAdd = Menu.getProductObjectFromSelection(command);
                    Menu.addStock(stockIncrease, productToAdd, inventory);
                    menuState = MenuState.OPTION_SELECTION;
                }
            }

            while (menuState == MenuState.ADD_ORDER) {
                ArrayList<ElectronicsProduct> products = new ArrayList<>();
                Menu.printMenu((MenuState.ADD_ORDER));
                String command = input.next();
                if (command.equals("exit")) {
                    menuState = MenuState.EXITING;
                    break;
                } else if (command.equals("7")) {
                    Menu.shipIt(order);
                    menuState = MenuState.OPTION_SELECTION;
                    break;
                }
                IAbstractElectronicsFactory factory = Menu.getAppropriateFactory(command);

                if (factory == null) {
                    System.out.println("-----------");
                    System.out.println("Invalid command. Try again:");
                } else {
                    System.out.println("How many to add to stock?");
                    String commandSelection = input.next();
                    int numberOfProducts = Menu.getNumberFromInput(commandSelection);
                    if (numberOfProducts == 1) {
                        switch (command) {
                            case "1":
                            case "2":
                            case "3":
                                products.add(factory.createTV());
                                break;
                            case "4":
                            case "5":
                            case "6":
                                products.add(factory.createRadio());
                                break;
                        }
                    } else {
                        switch (command) {
                            case "1":
                            case "2":
                            case "3":
                                for (int i = 0; i < numberOfProducts; i++) {
                                    products.add(factory.createTV());
                                }
                                break;
                            case "4":
                            case "5":
                            case "6":
                                for (int i = 0; i < numberOfProducts; i++) {
                                    products.add(factory.createRadio());
                                }
                                break;
                        }
                    }
                    order.products.addAll(products);
                }
            }

            if (menuState == MenuState.EXITING) {
                System.out.println("Exiting...");
                runApplication = false;
            }
        }
    }
}
