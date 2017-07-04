package com.triplebbackhillsbbq.triplebbackhillsbbq;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomArrayListAdaptor extends ArrayAdapter<MenuItem> {


    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param menuItem A List of menuItems objects to display in a list
     */
    CustomArrayListAdaptor(Activity context, ArrayList<MenuItem> menuItem) {
        // Initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, menuItem);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_list_item, parent, false);
        }

        // Get the {@link currentMenuItem} object located at this position in the list
        MenuItem currentMenuItem = getItem(position);

        // Find the TextView in the menu_list_item.xml layout with the ID menu_item_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.menu_item_name);
        // Get the menu item name from the current MenuItem object and
        // set this text on the name TextView
        assert currentMenuItem != null;
        nameTextView.setText(currentMenuItem.getMenuItemName());

        // Find the TextView in the menu_list_item.xml layout with the ID menu_item_description
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.menu_item_description);
        // Get the menu item description from the current MenuItem object and
        // set this text on the description TextView
        numberTextView.setText(currentMenuItem.getMenuItemDescription());

        // Find the ImageView in the menu_list_item.xml layout with the ID menu_item_image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.menu_item_image);
        // Get the image resource ID from the current MenuItem object and
        // set the image to menu_item_image
        iconView.setImageResource(currentMenuItem.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}