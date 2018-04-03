package com.company;

import java.time.LocalDate;

public class GroceryItem {
    LocalDate day;
    String item;
    int price;

    public GroceryItem() {
        day = LocalDate.now();
        item = "";
        price = 0;
    }
    public GroceryItem(LocalDate day, String item, int price) {
        this.day = day;
        this.item = item;
        this.price = price;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "day=" + day +
                ", item='" + item + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroceryItem that = (GroceryItem) o;

        if (price != that.price) return false;
        if (day != null ? !day.equals(that.day) : that.day != null) return false;
        return item != null ? item.equals(that.item) : that.item == null;
    }

    @Override
    public int hashCode() {
        int result = day != null ? day.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
