package com.theironyard.charlotte;

import java.util.Scanner;

class Car {
    private static String company;
    private static String year;
    private static String color;
    private static String convertible;
    private static String rimSize;

    public Car() {

    }

    private Car(String company, String year, String color, String convertible, String rimSize) {
        Car.company = company;
        Car.year = year;
        Car.color = color;
        Car.convertible = convertible;
        Car.rimSize = rimSize;
    }
    @Override
    public String toString() {
        return Car.year + ", " + Car.color + " " + Car.company + " " + Car.convertible + " with " + Car.rimSize + "\" rims.";
    }

    static Car createItem(){

        Scanner scanner = new Scanner(System.in);

        // prompt the user to answer questions about a car

        System.out.println("Questions about your car:\n");

        System.out.println("What company manufactured your car?");
        company = scanner.nextLine();

        System.out.println("What year is your car?");
        year = scanner.nextLine();

        System.out.println("What color is your car?");
        color = scanner.nextLine();

        System.out.println("Is it a convertible? [y/n]");
        convertible = scanner.nextLine();

        if (convertible.equalsIgnoreCase("Y")){

            convertible = "Convertible";

        } else {

            convertible = "Hardtop";
        }

        System.out.println("What size are the rims (Inches)?");
        rimSize = scanner.nextLine();

        return new Car (company, year, color, convertible, rimSize);
    }
}
