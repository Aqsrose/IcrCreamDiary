package com.example.icrcreamdiary;

public class IceCreamList {
    String title;
    String content;
    String image;

    public IceCreamList(String title, String content, String image) {
        this.title = title;
        this.content = content;
        this.image = image;

    }

    public IceCreamList(String addtitle, String addContent) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
