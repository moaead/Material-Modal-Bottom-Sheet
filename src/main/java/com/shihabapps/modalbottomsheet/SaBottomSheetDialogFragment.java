package com.shihabapps.modalbottomsheet;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SaBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private BottomSheetItemOnClickListener mCallback;

    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        int orientation = getArguments().getInt("orientation");

        View contentView = View.inflate(getContext(), orientation == BottomSheet.Builder.VERTICAL ?
                R.layout.bottom_sheet_vertical_fragment :
                R.layout.bottom_sheet_horizontal_fragment, null);
        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);

        List<BottomSheetItem> bottomSheetItems = new ArrayList<>();

        PopupMenu popupMenu = new PopupMenu(getContext(), contentView);
        Menu menu = popupMenu.getMenu();
        getActivity().getMenuInflater().inflate(getArguments().getInt("menu"), menu);

        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            int groupId = menuItem.getGroupId();
            bottomSheetItems.add(new BottomSheetItem(menuItem.getTitle().toString(), menuItem.getIcon(), menuItem.getItemId(), i + 1 < menu.size() && groupId != menu.getItem(i + 1).getGroupId()));
        }

        BottomSheetRecyclerAdapter adapter = new BottomSheetRecyclerAdapter(bottomSheetItems, orientation == BottomSheet.Builder.VERTICAL ?
                R.layout.bottom_sheet_single_item_vertical :
                R.layout.bottom_sheet_single_item_horziontal, mCallback);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(orientation == BottomSheet.Builder.VERTICAL ?
                new LinearLayoutManager(getContext()) :
                new GridLayoutManager(getContext(), 3));

        String title = getArguments().getString("title");
        if (title != null) {
            TextView bottomSheetTitleTextView = (TextView) contentView.findViewById(R.id.bottom_sheet_title_text_view);
            bottomSheetTitleTextView.setText(title);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
            layoutParams.topMargin = 0;
            recyclerView.setLayoutParams(layoutParams);
        } else {
            TextView bottomSheetTitleTextView = (TextView) contentView.findViewById(R.id.bottom_sheet_title_text_view);
            bottomSheetTitleTextView.setVisibility(View.GONE);
        }
        dialog.setContentView(contentView);
    }

    public void setCallback(BottomSheetItemOnClickListener callback) {
        mCallback = callback;
    }
}
