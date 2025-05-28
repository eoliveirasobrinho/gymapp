package com.project.gymapp.modules.products.models;

public class ProductDetails {

    private String weight;
    private String height;
    private String width;
    private String milliliter;

    public ProductDetails(String height, String milliliter, String weight, String width) {
        this.height = height;
        this.milliliter = milliliter;
        this.weight = weight;
        this.width = width;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getMilliliter() {
        return milliliter;
    }

    public void setMilliliter(String milliliter) {
        this.milliliter = milliliter;
    }

}
