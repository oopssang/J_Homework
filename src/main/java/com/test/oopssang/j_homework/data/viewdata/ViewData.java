package com.test.oopssang.j_homework.data.viewdata;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sang on 2017-05-17.
 *  이미지표시 시, 사용될 Data
 * @imageUrl 인스타그램 이미지 url   standard_resolution size의 이미지 사용
 * @width 이미지 가로 사이즈
 * @heigth 이미지 세로 사이즈
 * @id item ID
 */

public class ViewData implements Parcelable {
    private String imageUrl;
    private String thumvnailUrl;
    private int width;
    private int heigth;
    private String id;

    public String getImageUrl() {
        return imageUrl;
    }

    public String getThumvnailrl() {
        return thumvnailUrl;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public String getId() {
        return id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setThumvnailrl(String thumvnailUrl) {
        this.thumvnailUrl = thumvnailUrl;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public void setId(String id) {
        this.id = id;
    }


    public ViewData() {
    }

    public ViewData(Parcel in) {
        imageUrl = in.readString();
        thumvnailUrl = in.readString();
        width = in.readInt();
        heigth = in.readInt();
        id = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(thumvnailUrl);
        dest.writeInt(width);
        dest.writeInt(heigth);
        dest.writeString(id);
    }

    public static final Creator<ViewData> CREATOR = new Creator<ViewData>() {
        @Override
        public ViewData createFromParcel(Parcel source) {
            return new ViewData(source);
        }

        @Override
        public ViewData[] newArray(int size) {
            return new ViewData[size];
        }
    };
}
