package com.shihabapps.modalbottomsheet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.MenuRes;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;


public class BottomSheet {
    private final SaBottomSheetDialogFragment mBottomSheetDialogFragment;
    private final AppCompatActivity mActivity;
    private final Builder mBuilder;
    private final InternalClickListener mInternalClickListener;

    private BottomSheet(Builder builder) {
        mBuilder = builder;
        mBottomSheetDialogFragment = new SaBottomSheetDialogFragment();
        mInternalClickListener = new InternalClickListener();

        Bundle args = new Bundle();
        args.putInt("orientation", builder.getOrientation());
        args.putString("title", builder.getTitle());
        args.putParcelableArrayList("items", builder.getBottomSheetItems());
        args.putParcelable("callback", mInternalClickListener);
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
        private BottomSheetItemOnClickListener mOnClickHandler;
        private int mOrientation;
        private ArrayList<BottomSheetItem> mBottomSheetItems;

        public Builder(AppCompatActivity context) {
            mActivity = context;
            mOrientation = VERTICAL;
        }

        public ArrayList<BottomSheetItem> getBottomSheetItems() {
            return mBottomSheetItems;
        }

        public void setBottomSheetItems(ArrayList<BottomSheetItem> bottomSheetItems) {
            mBottomSheetItems = bottomSheetItems;
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

        public void setItems(ArrayList<BottomSheetItem> items) {
            mBottomSheetItems = items;
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

    public class InternalClickListener implements BottomSheetItemOnClickListener, Parcelable {
        public final Creator<InternalClickListener> CREATOR = new Creator<InternalClickListener>() {
            @Override
            public InternalClickListener createFromParcel(Parcel in) {
                return new InternalClickListener(in);
            }

            @Override
            public InternalClickListener[] newArray(int size) {
                return new InternalClickListener[size];
            }
        };

        protected InternalClickListener() {
        }

        protected InternalClickListener(Parcel in) {
        }

        @Override
        public void onClick(int position) {
            mBuilder.getOnClickHandler().onClick(position);

        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
        }
    }

}
