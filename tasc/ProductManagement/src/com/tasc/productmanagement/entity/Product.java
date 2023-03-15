package com.tasc.productmanagement.entity;

public class Product {
    private int id;
    private String name;
    private String producer;
    private String model;
    private double price;

    public Product() {
    }

    public Product(int id, String name, String producer, String model, double price) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        } else {
            System.out.println("Gia tri nhap vao khong hop le");
        }
    }
}
