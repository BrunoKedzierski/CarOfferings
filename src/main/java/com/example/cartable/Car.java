package com.example.cartable;

import java.sql.SQLException;

import static com.example.cartable.DbService.getAllCars;

public class Car {
    private String type;
    private String model;
    private String manufacturer;
    private int horsePower;
    private boolean electric;
    private String phoneNumber;
    private String contactMail;
    private double price;

    public Car(String type, String model, String manufacturer, int horsePower, boolean electric, String phoneNumber, String contactMail, double price) {
        this.type = type;
        this.model = model;
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
        this.electric = electric;
        this.phoneNumber = phoneNumber;
        this.contactMail = contactMail;
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("type='").append(type).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", horsePower=").append(horsePower);
        sb.append(", electric=").append(electric);
        sb.append('}');
        return sb.toString();
    }

    public String renderTableEntry(){
        final StringBuffer sb = new StringBuffer();
        sb.append("<td>").append(this.type).append("</td>").append("\n").
                append("<td>").append(this.model).append("</td>").append("\n").
                append("<td>").append(this.manufacturer).append("</td>").append("\n").
                append("<td>").append(this.horsePower).append("</td>").append("\n").
        append("<td>").append(this.phoneNumber).append("</td>").append("\n").
                append("<td>").append(this.contactMail).append("</td>").append("\n").
                append("<td>").append(this.price).append("</td>").append("\n");

        return sb.toString();



    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
