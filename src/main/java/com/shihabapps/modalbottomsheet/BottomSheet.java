package com.shihabapps.modalbottomsheet;

import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.v7.app.AppCompatActivity;


public class BottomSheet {
    private final SaBottomSheetDialogFragment mBottomSheetDialogFragment;
    private final AppCompatActivity mActivity;

    private BottomSheet(Builder builder) {
        mBottomSheetDialogFragment = new SaBottomSheetDialogFragment();

        Bundle args = new Bundle();
        args.putInt("menu", builder.getMenu());
        args.putInt("orientation", builder.getOrientation());
        args.putString("title", builder.getTitle());
        mBottomSheetDialogFragment.setCallback(builder.getOnClickHandler());
        mBottomSheetDialogFragment.setArguments(args);
        mActivity = builder.getActivity();
    }

    public void show() {
        mBottomSheetDialogFragment.show(mActivity.getSupportFragmentManager(), mBottomSheetDialogFragment.getTag());
    }

    public void dismiss() {
        mBottomSheetDialogFragment.dismiss();
    }

    public static class Builder {
        public static final int VERTICAL = 1;
        public static final int HORIZONTAL = 2;

        private final AppCompatActivity mActivity;
        private String mTitle;
        @MenuRes
        private int mMenu;
        private BottomSheetItemOnClickListener mOnClickHandler;
        private int mOrientation;

        public Builder(AppCompatActivity context) {
            mActivity = context;
            mOrientation = VERTICAL;
        }

        public AppCompatActivity getActivity() {
            return mActivity;
        }

        public String getTitle() {
            return mTitle;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public int getMenu() {
            return mMenu;
        }

        public Builder setMenu(int menu) {
            mMenu = menu;
            return this;
        }

        public BottomSheet create() {
            return new BottomSheet(this);
        }

        public BottomSheetItemOnClickListener getOnClickHandler() {
            return mOnClickHandler;
        }

        public void setOnClickHandler(BottomSheetItemOnClickListener onClickHandler) {
            mOnClickHandler = onClickHandler;
        }

        public int getOrientation() {
            return mOrientation;
        }

        public void setOrientation(int orientation) {
            mOrientation = orientation;
        }
    }
}
