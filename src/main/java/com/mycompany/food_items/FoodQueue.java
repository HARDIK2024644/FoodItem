/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.food_items;

/**
 *
 * @author hardi
 */

public class FoodQueue {
    private FoodItem[] queue;
    private int front, rear, size, capacity;

    public FoodQueue(int size) {
        this.capacity = size;
        this.queue = new FoodItem[size];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(FoodItem item) {
        if (isFull()) {
            System.out.println(" Queue is full! Max capacity is " + capacity + " trays.");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
        System.out.println(" Success: '" + item.getName() + "' added to queue storage.");
    }

    public FoodItem dequeue() {
        if (isEmpty()) {
            System.out.println(" Queue is empty! No food items to remove.");
            return null;
        }
        FoodItem removed = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        System.out.println("🗑️ Removed from Opposite Side (Queue Mode): " + removed.getName());
        return removed;
    }

    public FoodItem peek() {
        if (isEmpty()) {
            System.out.println("️ Queue storage is empty.");
            return null;
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println(" Queue Storage is currently empty.");
            return;
        }
        System.out.println("\n--- Current Queue Trays (Front to Rear) ---");
        int count = 0;
        int i = front;
        while (count < size) {
            System.out.println("Tray -> " + queue[i]);
            i = (i + 1) % capacity;
            count++;
        }
        System.out.println("------------------------------------------");
    }

    public void search(String searchName) {
        if (isEmpty()) {
            System.out.println("️ Storage is empty. Cannot search.");
            return;
        }
        boolean found = false;
        int count = 0;
        int i = front;
        while (count < size) {
            if (queue[i].getName().equalsIgnoreCase(searchName)) {
                System.out.println(" Found! Food item '" + searchName + "' -> " + queue[i]);
                found = true;
            }
            i = (i + 1) % capacity;
            count++;
        }
        if (!found) {
            System.out.println("Food item '" + searchName + "' not found in storage.");
        }
    }
}