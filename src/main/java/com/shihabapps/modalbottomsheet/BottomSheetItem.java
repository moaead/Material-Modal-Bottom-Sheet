package com.shihabapps.modalbottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

public class BottomSheetItem implements Parcelable {
    public static final Parcelable.Creator<BottomSheetItem> CREATOR = new Parcelable.Creator<BottomSheetItem>() {
        @Override
        public BottomSheetItem createFromParcel(Parcel source) {
            return new BottomSheetItem(source);
        }

        @Override
        public BottomSheetItem[] newArray(int size) {
            return new BottomSheetItem[size];
        }
    };

    @Nullable
    private Integer mImageTintColor;
    private String mTitle;
    private int mImage;
    private int mId;
    private boolean mIsGroup;

    public BottomSheetItem() {

    }

    public BottomSheetItem(String title, int image, int id, boolean isGroup) {

        mTitle = title;
        mImage = image;
        mId = id;
        mIsGroup = isGroup;
    }

    public BottomSheetItem(String title, int image, int id, boolean isGroup, Integer color) {

        mTitle = title;
        mImage = image;
        mId = id;
        mIsGroup = isGroup;
        mImageTintColor = color;
    }

    protected BottomSheetItem(Parcel in) {
        this.mTitle = in.readString();
        this.mImage = in.readParcelable(int.class.getClassLoader());
        this.mId = in.readInt();
        this.mIsGroup = in.readByte() != 0;
    }

    @Nullable
    public Integer getImageTintColor() {
        return mImageTintColor;
    }

    public void setImageTintColor(int imageTintColor) {
        mImageTintColor = imageTintColor;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public boolean isGroup() {
        return mIsGroup;
    }

    public void setGroup(boolean group) {
        mIsGroup = group;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeInt(this.mImage);
        dest.writeInt(this.mId);
        dest.writeByte(this.mIsGroup ? (byte) 1 : (byte) 0);
    }
}
