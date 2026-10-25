/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hardi
 */

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        FoodStack stack = new FoodStack();

        boolean running = true;

        while (running) {
            System.out.println("\n===== FAST FOOD STORAGE SYSTEM =====");
            System.out.println("1. Add food item");
            System.out.println("2. Remove top food item");
            System.out.println("3. View top food item");
            System.out.println("4. Display all food items");
            System.out.println("5. Search food item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = input.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Allowed foods: Burger, Pizza, Fries, Sandwich, Hotdog");
                    System.out.print("Enter food name: ");
                    String name = input.nextLine().trim();

                    if (!name.equalsIgnoreCase("Burger")
                            && !name.equalsIgnoreCase("Pizza")
                            && !name.equalsIgnoreCase("Fries")
                            && !name.equalsIgnoreCase("Sandwich")
                            && !name.equalsIgnoreCase("Hotdog")) {
                        System.out.println("Invalid food name.");
                        break;
                    }

                    System.out.print("Enter weight in grams: ");
                    int weight;

                    try {
                        weight = Integer.parseInt(input.nextLine());

                        if (weight <= 0) {
                            System.out.println("Weight must be positive.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid whole number.");
                        break;
                    }

                    System.out.print("Enter best-before date (YYYY-MM-DD): ");
                    LocalDate date;

                    try {
                        date = LocalDate.parse(input.nextLine());

                        if (date.isBefore(LocalDate.now())
                                || date.isAfter(LocalDate.now().plusDays(14))) {
                            System.out.println(
                                    "Date must be today or within the next 14 days.");
                            break;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println(
                                "Invalid date. Use YYYY-MM-DD, for example 2026-10-25.");
                        break;
                    }

                    FoodItem newItem = new FoodItem(name, weight, date);
                    stack.push(newItem);
                    break;

                case "2":
                    FoodItem removed = stack.pop();

                    if (removed != null) {
                        System.out.println("Removed food item: "
                                + removed.getName());
                    }
                    break;

                case "3":
                    FoodItem topItem = stack.peek();

                    if (topItem != null) {
                        System.out.println("Top food item:");
                        topItem.displayDetails();
                    }
                    break;

                case "4":
                    stack.display();
                    break;

                case "5":
                    System.out.print("Enter food name to search: ");
                    String searchName = input.nextLine().trim();
                    stack.search(searchName);
                    break;

                case "6":
                    running = false;
                    System.out.println("Application closed.");
                    break;

                default:
                    System.out.println(
                            "Invalid menu choice. Please enter 1 to 6.");
            }
        }

        input.close();
    }
}
