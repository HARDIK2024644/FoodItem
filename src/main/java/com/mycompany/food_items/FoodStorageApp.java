/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.food_items;

/**
 *
 * @author hardi
 */


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FoodStorageApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_TRAYS = 8; // Mandatory assignment limit of 8 trays[cite: 1]

        System.out.println("=== CCT Fast-Food Storage Application ===");
        System.out.println("Select Operating Mode:");
        System.out.println("1. Stack Mode (Front side used for both adding & removing - LIFO)[cite: 1]");
        System.out.println("2. Queue Mode (Front side for adding, opposite side for removing - FIFO)[cite: 1]");
        System.out.print("Enter choice (1 or 2): ");

        int modeChoice = 1;
        if (scanner.hasNextInt()) {
            modeChoice = scanner.nextInt();
        }

        FoodStack stackStorage = null;
        FoodQueue queueStorage = null;
        boolean isStack = (modeChoice != 2);

        if (isStack) {
            stackStorage = new FoodStack(MAX_TRAYS);
            System.out.println("\n--> Active Mode: STACK (Max Capacity: 8 trays)[cite: 1]");
        } else {
            queueStorage = new FoodQueue(MAX_TRAYS);
            System.out.println("\n--> Active Mode: QUEUE (Max Capacity: 8 trays)[cite: 1]");
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Storage Menu ---");
            System.out.println("1. Add Food Item");
            System.out.println("2. Remove Food Item");
            System.out.println("3. Peek Top/Front Item");
            System.out.println("4. Search Food Item");
            System.out.println("5. Display All Trays");
            System.out.println("6. View Time Complexities");
            System.out.println("7. Exit Application");
            System.out.print("Choose an option (1-7): ");

            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid choice format. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter food name (Burger, Pizza, Fries, Sandwich, Hotdog)[cite: 1]: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("❌ Error: Name cannot be blank.");
                        break;
                    }

                    System.out.print("Enter weight in grams (e.g., 250.0): ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("❌ Error: Invalid weight format.");
                        scanner.next();
                        break;
                    }
                    double weight = scanner.nextDouble();
                    if (weight <= 0) {
                        System.out.println("❌ Error: Weight must be greater than 0.");
                        break;
                    }

                    System.out.print("Enter best-before days (Max 2 weeks / 1 to 14 days)[cite: 1]: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("❌ Error: Invalid days format.");
                        scanner.next();
                        break;
                    }
                    int days = scanner.nextInt();
                    if (days < 1 || days > 14) {
                        System.out.println("❌ Error: Best-before must be between 1 and 14 days[cite: 1].");
                        break;
                    }

                    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    FoodItem newItem = new FoodItem(name, weight, days, timestamp);

                    if (isStack) {
                        stackStorage.push(newItem);
                    } else {
                        queueStorage.enqueue(newItem);
                    }
                    break;

                case 2:
                    if (isStack) {
                        stackStorage.pop();
                    } else {
                        queueStorage.dequeue();
                    }
                    break;

                case 3:
                    FoodItem topItem = isStack ? stackStorage.peek() : queueStorage.peek();
                    if (topItem != null) {
                        System.out.println("👁️ Current Top/Front Item -> " + topItem);
                    }
                    break;

                case 4:
                    System.out.print("Enter food name to search: ");
                    String searchName = scanner.nextLine().trim();
                    if (isStack) {
                        stackStorage.search(searchName);
                    } else {
                        queueStorage.search(searchName);
                    }
                    break;

                case 5:
                    if (isStack) {
                        stackStorage.display();
                    } else {
                        queueStorage.display();
                    }
                    break;

                case 6:
                    System.out.println("\n=== TIME COMPLEXITY ANALYSIS ===");
                    System.out.println("• Add (Push/Enqueue) : O(1) - Constant time insertion.");
                    System.out.println("• Remove (Pop/Dequeue): O(1) - Direct pointer removal.");
                    System.out.println("• Peek               : O(1) - Instant inspection.");
                    System.out.println("• Search             : O(N) - Linear scan through active trays.");
                    System.out.println("• Display            : O(N) - Traversing all elements.");
                    break;

                case 7:
                    running = false;
                    System.out.println("👋 Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid option. Choose between 1 and 7.");
            }
        }
        scanner.close();
    }
}