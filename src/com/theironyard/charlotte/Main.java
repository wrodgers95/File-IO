package com.theironyard.charlotte;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        File f = new File("Car.Json");

        if (f.exists()) {

            System.out.println(f.getName());

            System.out.println(" File 'Car.Json' found...\n");
            System.out.println("Would you like to update 'Car' information? (Y or N)");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("Y")) {
                Car c = Car.createItem();

                //  Serializing Car Object (converting Java to Json)
                // saving info to Json file

                JsonSerializer s = new JsonSerializer();
                String JsonCar = s.serialize(c);
                FileWriter fw = new FileWriter(f);
                fw.write(JsonCar);
                fw.close();

                // reading Json file and printing updated information
                Scanner d = new Scanner(f);
                d.useDelimiter("\\Z");
                String contents = d.next();
                JsonParser parser = new JsonParser();
                Car c2 = parser.parse(contents, Car.class);

                System.out.println(c2);

            } else if (option.equalsIgnoreCase("N")) {

                System.out.println("Your file will not be updated. Process terminating...");

            }

        } else {

            Car c = Car.createItem();

            JsonSerializer s = new JsonSerializer();
            String JsonCar = s.serialize(c);
            FileWriter fw = new FileWriter(f);
            fw.write(JsonCar);
            fw.close();

            // reading Json file and printing updated information
            Scanner d = new Scanner(f);
            d.useDelimiter("\\Z");
            String contents = d.next();
            JsonParser parser = new JsonParser();
            Car c2 = parser.parse(contents, Car.class);

            System.out.println(c2);

        }
    }
}