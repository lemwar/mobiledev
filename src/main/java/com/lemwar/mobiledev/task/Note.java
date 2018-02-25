package com.lemwar.mobiledev.task;

import java.util.Date;

public class Note {
    private String id;
    private String title;
    private String text;
    private long date_create;
    private long date_update;



public Note(){

}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getDate_create() {
        return date_create;
    }

    public void setDate_create(long date_create) {
        this.date_create = date_create;
    }

    public long getDate_update() {
        return date_update;
    }

    public void setDate_update(long date_update) {
        this.date_update = date_update;
    }
}
