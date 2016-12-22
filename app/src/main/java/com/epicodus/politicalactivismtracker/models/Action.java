package com.epicodus.politicalactivismtracker.models;

/**
 * Created by jensese on 12/21/16.
 */

public class Action {
    private String name;
    private String location;
    private String link;
    private String date;
    private String description;
    private int imageUrl;
    private String categoryCause;
    private String categoryAction;
    private int price;
    private String iDidThis;

    public Action() {
    }

    public Action(String name, String location, String link, String date, String description, int imageUrl, String categoryCause, String categoryAction, int price) {
        this.name = name;
        this.location = location;
        this.link = link;
        this.date = date;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryCause = categoryCause;
        this.categoryAction = categoryAction;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getLink() {
        return link;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getCategoryCause() {
        return categoryCause;
    }

    public String getCategoryAction() {
        return categoryAction;
    }

    public int getPrice() {
        return price;
    }

    public String getIDidThis() {
        return iDidThis;
    }
}
