/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.food_items;

/**
 *
 * @author hardi
 */
public class FoodItem {
    private String name;
    private double weight; // in grams
    private int bestBeforeDays; // max 2 weeks (1-14 days)
    private String timeAdded;

    public FoodItem(String name, double weight, int bestBeforeDays, String timeAdded) {
        this.name = name;
        this.weight = weight;
        this.bestBeforeDays = bestBeforeDays;
        this.timeAdded = timeAdded;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public int getBestBeforeDays() { return bestBeforeDays; }
    public String getTimeAdded() { return timeAdded; }

    @Override
    public String toString() {
        return "Food: " + name + " | Weight: " + weight + "g | Best-Before: " + bestBeforeDays + " days | Added At: " + timeAdded;
    }
}