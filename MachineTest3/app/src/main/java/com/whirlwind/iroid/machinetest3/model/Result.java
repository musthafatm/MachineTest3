package com.whirlwind.iroid.machinetest3.model;

/**
 * Created by Muhammed on 02/08/17.
 */

public class Result {
    private String title;

    private String[] image_url;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImage_url() {
        return image_url;
    }

    public void setImage_url(String[] image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ClassPojo [title = " + title + ", image_url = " + image_url + ", description = " + description + "]";
    }
}
