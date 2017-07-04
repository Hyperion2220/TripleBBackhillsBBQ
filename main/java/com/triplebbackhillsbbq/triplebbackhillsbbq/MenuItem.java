package com.triplebbackhillsbbq.triplebbackhillsbbq;


class MenuItem {

    /**
     * {@link MenuItem} represents a single menu item.
     * Each object has 3 properties: item name, item description, and image resource ID.
     */

    // Name of the Menu Item (e.g. Pulled Pig, Ruben, Junk Yard Dog)
    private String mMenuItemName;

    // Description of the Menu Item
    private String mMenuItemDescription;

    // Drawable resource ID (image of the menu item)
    private int mImageResourceId;

    /*
    * Create a new MenuItem object.
    *
    * @param vName is the name of the Menu Item (e.g. Pulled Pig)
    * @param vNumber is the corresponding description of the Menu Item
    * @param image is drawable reference ID that corresponds to the image of the Menu Item
    * */
    MenuItem(String vName, String vDescription, int imageResourceId) {
        mMenuItemName = vName;
        mMenuItemDescription = vDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the Menu Item
     */
    String getMenuItemName() {
        return mMenuItemName;
    }

    /**
     * Get the description of the Menu Item
     */
    String getMenuItemDescription() {
        return mMenuItemDescription;
    }

    /**
     * Get the image resource ID for the Menu Item
     */
    int getImageResourceId() {
        return mImageResourceId;
    }


}




