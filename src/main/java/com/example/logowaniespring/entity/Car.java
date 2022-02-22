package com.example.logowaniespring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    String mark;
    String model;
    int productionYear;
    double price;
    boolean isAvailable;

    public Car (int id, String mark, String model, int productionYear, double price, boolean isAvailable){
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    public Car(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
    public void displayCarList(){
        String ava;
        if (isAvailable == true)
            ava = "TAK";
        else
            ava= "NIE";
        System.out.println(mark + " " + model + " " + productionYear + " Dostepny:" + ava);
    }

}
