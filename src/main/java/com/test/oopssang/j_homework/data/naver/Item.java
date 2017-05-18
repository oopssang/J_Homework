package com.test.oopssang.j_homework.data.naver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sang on 2017-05-17.
 */

public class Item {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("sizeheight")
    @Expose
    private String sizeheight;
    @SerializedName("sizewidth")
    @Expose
    private String sizewidth;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSizeheight() {
        return sizeheight;
    }

    public void setSizeheight(String sizeheight) {
        this.sizeheight = sizeheight;
    }

    public String getSizewidth() {
        return sizewidth;
    }

    public void setSizewidth(String sizewidth) {
        this.sizewidth = sizewidth;
    }

}