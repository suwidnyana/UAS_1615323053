package com.example.uas_1615323053;

public class Artikel {

    private int imageId;
    private String title;
    private String timestamp;
    private String descriptions;
    public Artikel(int imageId, String title, String timestamp, String descriptions)
    {
        this.imageId = imageId;
        this.title = title;
        this.timestamp = timestamp;
        this.descriptions = descriptions;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}

