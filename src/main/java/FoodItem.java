/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hardi
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
public class FoodItem {

    private String name;
    private int weight;
    private LocalDate bestBefore;
    private LocalDateTime timeAdded;

    public FoodItem(String name, int weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timeAdded = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }

    public void displayDetails() {
        System.out.println("Food: " + name);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Best-before date: " + bestBefore);
        System.out.println("Time added: " + timeAdded);
    }
}