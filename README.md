Material Bottom Sheet
=====================
Material Action Bottom Sheet using android support libraries and recycleviews. supports both vertical and horizontal.

<img src="http://i.imgur.com/lyP9lQK.png" width="320" height="550" />
<img src="http://i.imgur.com/SyXHn3J.png" width="320" height="550" />
<img src="http://i.imgur.com/NV72Lty.png" width="320" height="550" />

Installation
============
```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.shihabapps.moaead:modal-bottom-sheet:0.1'
}

```
Getting Started
===============
```java
BottomSheet.Builder bottomSheetBuilder = new BottomSheet.Builder(MainActivity.this);
bottomSheetBuilder.setTitle("Open in");
final ArrayList<BottomSheetItem> items = new ArrayList<>();

items.add(new BottomSheetItem("Share", R.drawable.ic_share_black_24dp, 0, false, Color.RED));
items.add(new BottomSheetItem("Share", R.drawable.ic_share_black_24dp, 0, false, Color.GREEN));
items.add(new BottomSheetItem("Share", R.drawable.ic_share_black_24dp, 0, false, Color.YELLOW));
items.add(new BottomSheetItem("Share", R.drawable.ic_share_black_24dp, 0, false, Color.BLUE));
items.add(new BottomSheetItem("Share", R.drawable.ic_share_black_24dp, 0, false, ContextCompat.getColor(MainActivity.this, R.color.colorPrimary)));
items.add(new BottomSheetItem("ShareAbc", R.drawable.ic_share_black_24dp, 0, false));

bottomSheetBuilder.setItems(items);
bottomSheetBuilder.setOrientation(BottomSheet.Builder.VERTICAL);
bottomSheetBuilder.setOnClickHandler(new BottomSheetItemOnClickListener() {
    @Override
    public void onClick(int position) {
        String title = items.get(position).getTitle();
        Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
    }
});
mBottomSheet = bottomSheetBuilder.create();
mBottomSheet.show();
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        mBottomSheet.dismiss(); //just an example of using dismiss
    }
}, 3000);
```