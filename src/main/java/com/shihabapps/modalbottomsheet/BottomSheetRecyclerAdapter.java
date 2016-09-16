package com.shihabapps.modalbottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BottomSheetRecyclerAdapter extends RecyclerView.Adapter<BottomSheetRecyclerAdapter.ViewHolder> {
    private final int mItemResourceId;
    private final List<BottomSheetItem> mBottomSheetItems;
    private final BottomSheetItemOnClickListener mOnClickListener;
    private final Context mContext;

    public BottomSheetRecyclerAdapter(Context context, List<BottomSheetItem> bottomSheetItems, int itemResourceId, BottomSheetItemOnClickListener onClickListener) {
        mContext = context;
        mBottomSheetItems = bottomSheetItems;
        mItemResourceId = itemResourceId;
        mOnClickListener = onClickListener;
    }

    public Drawable getDrawableWithTint(int drawableResource, int color) {
        Drawable drawable = ContextCompat.getDrawable(mContext, drawableResource).mutate();
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, ColorStateList.valueOf(color));
        return wrappedDrawable;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(mItemResourceId, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BottomSheetRecyclerAdapter.ViewHolder holder, int position) {
        BottomSheetItem bottomSheetItem = mBottomSheetItems.get(position);
        holder.mTextView.setText(bottomSheetItem.getTitle());
        if (bottomSheetItem.getImage() != 0) {
            if (bottomSheetItem.getImageTintColor() != null) {
                holder.mImageView.setImageDrawable(getDrawableWithTint(bottomSheetItem.getImage(), bottomSheetItem.getImageTintColor()));
            } else {
                holder.mImageView.setImageResource(bottomSheetItem.getImage());
            }
        }
        if (bottomSheetItem.isGroup()) {
            holder.mDividerView.setVisibility(View.VISIBLE);
        }
        holder.bind(position, mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mBottomSheetItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final View mDividerView;
        private final ImageView mImageView;
        private final TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.bottom_sheet_single_title_text_view);
            mImageView = (ImageView) itemView.findViewById(R.id.bottom_sheet_single_title_image_view);
            mDividerView = itemView.findViewById(R.id.bottom_sheet_single_title_divider_view);
        }

        public void bind(final int position, final BottomSheetItemOnClickListener onClickListener) {
            View childLinear = itemView.findViewById(R.id.bottom_sheet_single_image_and_text);
            if (childLinear == null)
                childLinear = itemView;

            childLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(position);
                }
            });
        }
    }
}
