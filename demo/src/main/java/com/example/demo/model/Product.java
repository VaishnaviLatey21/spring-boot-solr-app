package com.example.demo.model;

import org.apache.solr.client.solrj.beans.Field;

public class Product {
    @Field
    private String id;

    @Field
    private String name;

    @Field
    private double price;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
