package com.shihabapps.modalbottomsheet;

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

    public BottomSheetRecyclerAdapter(List<BottomSheetItem> bottomSheetItems, int itemResourceId, BottomSheetItemOnClickListener onClickListener) {
        mBottomSheetItems = bottomSheetItems;
        mItemResourceId = itemResourceId;
        mOnClickListener = onClickListener;
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
        if (bottomSheetItem.getImage() != null) {
            holder.mImageView.setImageDrawable(bottomSheetItem.getImage());
        }
        if (bottomSheetItem.isGroup()) {
            holder.mDividerView.setVisibility(View.VISIBLE);
        }
        holder.bind(bottomSheetItem, mOnClickListener);
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

        public void bind(final BottomSheetItem item, final BottomSheetItemOnClickListener onClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(item.getId(), item.getTitle());
                }
            });
        }
    }
}
