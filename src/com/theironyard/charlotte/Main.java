package com.theironyard.charlotte;

/*
Objectives:
Prompt the user to answer at least five different questions about a good or service. --
Save the information into a JSON object in a file. --
When the program first boots, read the file and display the contents. ??
Give the user the ability to update the information and re-save it to the file.
If the JSON parsing fails, give a friendly error rather than crashing the program.

 */

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // creating file...

        File f = new File("Car.Json");

        // make loop to prompt- update info or write

        while (true) {

            

            System.out.println("Would you like to update this information? (Y or N)");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("Y")) {

                // prompt the user to answer questions about a car

                System.out.println("Questions about your car:\n");

                // question 1
                System.out.println("What company manufactured your car?");
                String company = scanner.nextLine();

                // question 2
                System.out.println("What year is your car?");
                String year = scanner.nextLine();

                // question 3
                System.out.println("What color is your car?");
                String color = scanner.nextLine();

                // question 4
                System.out.println("Is it a convertible? [y/n]");
                String convertible = scanner.nextLine();
                if (convertible.equalsIgnoreCase("Y")){
                    convertible = "Convertible";
                } else {
                    convertible = "Not Convertible";
                }

                // question 5
                System.out.println("What size are the rims (In Inches)?");
                String rimSize = scanner.nextLine();

                Car c = Car.createItem(company, year, color, convertible, rimSize);

                //  Serializing Car Object (converting Java to Json)
                // saving info to Json file

                JsonSerializer s = new JsonSerializer();
                String JsonCar = s.serialize(c);
                FileWriter fw = new FileWriter(f);
                fw.write(JsonCar);
                fw.close();

                // read Json file
                Scanner j = new Scanner(f);
                j.useDelimiter("\\Z");
                String contents = j.next();
                JsonParser parser = new JsonParser();
                Car c2 = parser.parse(contents, Car.class);

                System.out.println(c2);

                continue;

            } else if (option.equalsIgnoreCase("N")){

                // prompt the user to answer questions about a car

                System.out.println("Questions about your car:\n");

                // question 1
                System.out.println("What company manufactured your car?");
                String company = scanner.nextLine();

                // question 2
                System.out.println("What year is your car?");
                String year = scanner.nextLine();

                // question 3
                System.out.println("What color is your car?");
                String color = scanner.nextLine();

                // question 4
                System.out.println("Is it a convertible? [y/n]");
                String convertible = scanner.nextLine();
                    if (convertible.equalsIgnoreCase("Y")){
                        convertible = "Convertible";
                    } else {
                        convertible = "Not Convertible";
                    }

                // question 5
                System.out.println("What size are the rims (In Inches)?");
                String rimSize = scanner.nextLine();

                Car c = Car.createItem(company, year, color, convertible, rimSize);

                //  Serializing Car Object (converting Java to Json)
                // saving info to Json file

                JsonSerializer s = new JsonSerializer();
                String JsonCar = s.serialize(c);
                FileWriter fw = new FileWriter(f);
                fw.write(JsonCar);
                fw.close();

                // read Json file
                Scanner j = new Scanner(f);
                j.useDelimiter("\\Z");
                String contents = j.next();
                JsonParser parser = new JsonParser();
                Car c2 = parser.parse(contents, Car.class);

                System.out.println(c2);

                // Give the user the ability to update the information and re-save it to the file.
                break;

            }

            return;
        }
    }
}