package exam.project;

import exam.project.Products.ElectronicsProduct;

import java.util.ArrayList;

public class Menu {
    private static void printProductList() {
        System.out.println("1: Discount TV");
        System.out.println("2: Mid-tier TV");
        System.out.println("3: Designer TV");
        System.out.println("4: Discount Radio");
        System.out.println("5: Mid-tier Radio");
        System.out.println("6: Designer Radio");
    }

    public static void printMenu(MenuState menuState) {
        switch (menuState) {
            case OPTION_SELECTION:
                System.out.println("Select an option:");
                System.out.println("1: Add stock");
                System.out.println("2: Ship order");
                break;
            case ADD_PRODUCT:
                System.out.println("Which product do you wish to increase?");
                printProductList();
                break;
            case SHIP_ORDER:
                System.out.println("Which products do you wish to ship?");
                printProductList();
                System.out.println("7: All done - ship it!");
                break;
            default:
                System.out.println("Unknown state.");
                break;
        }
    }

    public static MenuState getOptionState(MenuState menuState, String option) {
        if (option.toLowerCase().equals("exit")) {
            return MenuState.EXITING;
        }
        if (menuState == MenuState.OPTION_SELECTION) {
            switch (option) {
                case "1":
                    return MenuState.ADD_PRODUCT;
                case "2":
                    return MenuState.SHIP_ORDER;
                default:
                    return MenuState.OPTION_SELECTION;
            }
        }
        return MenuState.EXITING;
    }

    public static String getProductFromSelection(String stockToIncrease) {
        switch (stockToIncrease) {
            case "1":
                return "Discount TV";
            case "2":
                return "Mid-tier TV";
            case "3":
                return "Designer TV";
            case "4":
                return "Discount Radio";
            case "5":
                return "Mid-tier Radio";
            case "6":
                return "Designer Radio";
            default:
                return null;
        }
    }

    public static int getNumberFromInput(String increase) {
        int increaseInt = 0;
        if (increase == null) {
            return increaseInt;
        }
        try {
            increaseInt = Integer.parseInt(increase);
        } catch (NumberFormatException nfe) {
            return increaseInt;
        }
        return increaseInt;
    }

    public static void addStock(int increase, String product) {
        // TODO
        System.out.println("Add " + increase + " to " + product + " stock.");
    }

    public static void addToOrder(int increase, String product, ArrayList<ElectronicsProduct> products) {
        // TODO - should return array of electronic products
        System.out.println("Add " + increase + " " + product + "s to from stock to order.");
    }

    // TODO
    public static void shipIt() {
        System.out.println("Shipping it!");
    }
}
