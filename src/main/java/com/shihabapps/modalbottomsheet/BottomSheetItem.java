package com.shihabapps.modalbottomsheet;

import android.graphics.drawable.Drawable;

class BottomSheetItem {
    private String mTitle;
    private Drawable mImage;
    private int mId;
    private boolean mIsGroup;

    public BottomSheetItem(String title, Drawable image, int id, boolean isGroup) {

        mTitle = title;
        mImage = image;
        mId = id;
        mIsGroup = isGroup;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Drawable getImage() {
        return mImage;
    }

    public void setImage(Drawable image) {
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
}
