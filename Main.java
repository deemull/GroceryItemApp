package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello World! ");

        GroceryItem cart1 = new GroceryItem();
        GroceryItem cart2 = new GroceryItem();
        GroceryItem cart3 = new GroceryItem();

        ArrayList<GroceryItem> groceries = new ArrayList<>();
        groceries.add(cart1);
        groceries.add(cart2);
        groceries.add(cart3);

        GroceryList groceryItems = new GroceryList();

        //Write grocery item(s) to the file input.txt
        writeInFile(groceries);

        //Number of items were purchased during the last visit to the grocery store
        int numItemsPurchasedLastVisit = howManyPurchasedLastVisit(groceries);
        System.out.println("How many items purchased last visit? " + numItemsPurchasedLastVisit);


        LocalDate yesterday = LocalDate.now().minusDays(1);// yesterday's date as a LocalDate object
        int total = totalPricesPurchasedOn( groceries, yesterday );
        System.out.println(total);

        //int itemTotal = countItem();

        //Items purchased that cost more than $10
        ArrayList<String> storeList = itemsPurchasedOverAmount(groceries);
        System.out.println("Purchased Item(s) over $10.00: " + storeList);


        //
        String userItemInput = "eggs";
        int amountOfTimesPurchased = numTimesItemPurchased(groceries, userItemInput);
        System.out.println(userItemInput + " Purchase Occurrence(s): " + amountOfTimesPurchased);



    }

    private static void writeInFile(ArrayList<GroceryItem> groceryItems) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("input.txt");
        //writes a nullable object to the PrintWriter
        printWriter.print(groceryItems);
        printWriter.close();
    }

    public static int howManyPurchasedLastVisit(ArrayList<GroceryItem> groceries) {
        int count = 0;
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).getDay().isAfter(LocalDate.now().minusDays(1))) {
                count++;
            }
        }
        return count;
    }
    public static int totalPricesPurchasedOn(ArrayList<GroceryItem> groceries, LocalDate date) {
        int sum = 0;
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).getDay().equals(date)) {
                sum += groceries.get(i).getPrice();
            }
        }
        return sum;
    }
    private static ArrayList<String> itemsPurchasedOverAmount(ArrayList<GroceryItem> listOfItems) {
        String item = "";
        int itemAmount = 10;
        ArrayList<String> itemsOverAmount = new ArrayList<>();
        for (int i = 0; i < listOfItems.size(); i++) {
            if (listOfItems.get(i).getPrice() > itemAmount) {
                item = listOfItems.get(i).getItem();
                itemsOverAmount.add(item);
            }
        }
        return itemsOverAmount;
    }
    private static int numTimesItemPurchased(ArrayList<GroceryItem> groceries, String storeItem) {
        int count = 0;
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).getItem().equals(storeItem)) {
                count++;
            }
        }
        return count;
    }
}
