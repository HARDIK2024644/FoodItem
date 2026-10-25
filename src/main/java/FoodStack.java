/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hardi
 */
package com.mycompany.food_items;

public class FoodStack {

    private FoodItem[] items;
    private int top;
    private final int CAPACITY = 8;

    public FoodStack() {
        items = new FoodItem[CAPACITY];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == CAPACITY - 1;
    }

    public void push(FoodItem item) {
        if (isFull()) {
            System.out.println("Storage is full. Maximum is 8 trays.");
            return;
        }

        top++;
        items[top] = item;
        System.out.println("Food item added successfully.");
    }

    public FoodItem pop() {
        if (isEmpty()) {
            System.out.println("Storage is empty. Nothing to remove.");
            return null;
        }

        FoodItem removedItem = items[top];
        items[top] = null;
        top--;

        return removedItem;
    }

    public FoodItem peek() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return null;
        }

        return items[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }

        System.out.println("\n--- Stored Food Items ---");

        for (int i = top; i >= 0; i--) {
            System.out.println("\nPosition: "
                    + (i == top ? "TOP" : i == 0 ? "BOTTOM" : i));
            items[i].displayDetails();
        }
    }

    public void search(String foodName) {
        boolean found = false;

        for (int i = top; i >= 0; i--) {
            if (items[i].getName().equalsIgnoreCase(foodName)) {
                System.out.println("Food item found:");
                items[i].displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Food item not found.");
        }
    }
}
