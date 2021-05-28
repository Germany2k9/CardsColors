package com.germany.cardscolors;

import android.content.res.TypedArray;

import java.io.Serializable;

public class Sport implements Serializable {

    private final int imageResource;
    private String title;
    private String  info;

    public Sport(String title, String info, int imageResource ) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
