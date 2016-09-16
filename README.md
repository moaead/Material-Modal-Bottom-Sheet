Material Bottom Sheet
=====================
Material Action Bottom Sheet using android support libraries and recycleviews. supports both vertical and horizontal.

Installation
============
```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.shihabapps.modal-bottom-sheet:modal-bottom-sheet:0.1'
}

```
Getting Started
===============
```java
BottomSheet.Builder bottomSheetBuilder = new BottomSheet.Builder(MainActivity.this);
bottomSheetBuilder.setTitle("Open in");
bottomSheetBuilder.setMenu(R.menu.fragment_menu);
bottomSheetBuilder.setOrientation(BottomSheet.Builder.HORIZONTAL);
bottomSheetBuilder.setOnClickHandler(new BottomSheetItemOnClickListener() {
    @Override
    public void onClick(int id, String title) {

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