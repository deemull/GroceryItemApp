package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class GroceryList {
    private ArrayList<GroceryItem> groceryItems;

    public GroceryList() {
        groceryItems = new ArrayList<>();
    }
    public void writeInFile(ArrayList<GroceryItem> groceryItems) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("input.txt");
        //writes a nullable object to the PrintWriter
        printWriter.print(groceryItems);
        printWriter.close();
    }

    public int howManyPurchasedLastVisit(ArrayList<GroceryItem> groceries) {
        LocalDate date = groceries.get(0).getDay();
        int count = 0;
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).getDay().isAfter(date)) {
                date = groceries.get(i).getDay();
            }
        }
        for (int i = 0; i < groceries.size(); i++) {
            if (date == groceries.get(i).getDay()) {
                count++;
            }
        }
        return count;
    }

    public int totalPricesPurchasedOn(ArrayList<GroceryItem> groceries, LocalDate date) {
        int sum = 0;
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).getDay().equals(date)) {
                sum += groceries.get(i).getPrice();
            }
        }
        return sum;
    }

    public ArrayList<GroceryItem> itemsPurchasedOverAmount(ArrayList<GroceryItem> groceries) {
        int itemAmount = 10;
        ArrayList<GroceryItem> itemsOverAmount = new ArrayList<>();
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).getPrice() > itemAmount) {
                itemsOverAmount.add(groceries.get(i));
            }
        }
        return itemsOverAmount;
    }

    public int numTimesItemPurchased(ArrayList<GroceryItem> groceries, String storeItem) {
        int count = 0;
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).getItem().equals(storeItem)) {
                count++;
            }
        }
        return count;
    }
}
