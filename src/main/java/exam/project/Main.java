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

            while (menuState == MenuState.ADD_PRODUCT) {
                Menu.printMenu(MenuState.ADD_PRODUCT);
                String command = input.next();
                String productToAddType = Menu.getProductFromSelection(command);
                if (productToAddType == null) {
                    System.out.println("-----------");
                    System.out.println("Invalid command. Try again:");
                } else {
                    System.out.println("How many to add to stock?");
                    int stockIncrease = Menu.getNumberFromInput(input.next());
                    ElectronicsProduct productToAdd = Menu.getProductObjectFromSelection(command);
                    Menu.addStock(stockIncrease, productToAdd, productToAddType);
                    menuState = MenuState.OPTION_SELECTION;
                }
            }

            while (menuState == MenuState.SHIP_ORDER) {
                ArrayList<ElectronicsProduct> products = new ArrayList<>();
                Menu.printMenu((MenuState.SHIP_ORDER));
                String command = input.next();
                if (command.equals("exit")) {
                    menuState = MenuState.EXITING;
                    break;
                } else if (command.equals("7")) {
                    Menu.shipIt();
                    menuState = MenuState.OPTION_SELECTION;
                    break;
                }
                String productToPurchase = Menu.getProductFromSelection(command);
                if (productToPurchase == null) {
                    System.out.println("-----------");
                    System.out.println("Invalid command. Try again:");
                } else {
                    System.out.println("How many to add to stock?");
                    String commandSelection = input.next();
                    int numberOfProducts = Menu.getNumberFromInput(commandSelection);
                    Menu.addToOrder(numberOfProducts, productToPurchase, products);
                    //Order newOrder = new Order();
                }
            }
        }
    }
}
