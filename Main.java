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

        writeInFile(groceries);


        int numItemsPurchasedLastVisit = howManyPurchasedLastVisit(groceries);
        System.out.println( "How many items purchased last visit? " + numItemsPurchasedLastVisit );

        LocalDate yesterday = LocalDate.now().minusDays(1);// yesterday's date as a LocalDate object
        //int total = totalPricesPurchasedOn( yesterday );

        //int itemTotal = countItem();





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
            count++;
        }
        return count;
    }
    /*public static int totalPricesPurchasedOn(LocalDate yesterday) {
        int count = 0;


    }
    */


}
