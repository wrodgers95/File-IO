package com.theironyard.charlotte;

public class Car {
    String company;
    String year;
    String color;
    String convertible;
    String rimSize;

    public Car() {

    }

    public Car(String company, String year, String color, String convertible, String rimSize) {
        this.company = company;
        this.year = year;
        this.color = color;
        this.convertible = convertible;
        this.rimSize = rimSize;
    }
    @Override
    public String toString() {
        return this.year + ", " + this.color + " " + this.company + " " + this.convertible + " with " + this.rimSize + " \" rims.";
    }

    public static Car createItem(String company, String year, String color, String convertible, String rimSize){
        return new Car(company, year, color, convertible, rimSize);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getConvertible() {
        return convertible;
    }

    public void setConvertible(String convertible) {
        this.convertible = convertible;
    }

    public String getRimSize() {
        return rimSize;
    }

    public void setRimSize(String rimSize) {
        this.rimSize = rimSize;
    }
}

