package com.triplebbackhillsbbq.triplebbackhillsbbq;

import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class CustomAdapter extends PagerAdapter {

    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public CustomAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }


    /**
     * Removes the page for the given position from the container. Here we have simply removed object using removeView().
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    /**
     * returns the number of available views in the ViewPager.
     */
    @Override
    public int getCount() {
        return images.size();
    }

    /**
     * This method should create the page for the position passed to it as an argument.
     * Here we inflate() the slide.xml layout to create the android images slider set the image resource for the ImageView in it.
     * Finally, the inflated view is added to the ViewPager using addView() and return it.
     */
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.slide, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.image);
        myImage.setImageResource(images.get(position));
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    /**
     * This method checks whether the view passed to it is associated with the key returned by the instantiateItem().
     * This method is important for proper functioning of the PagerAdapter.
     * We just compare the two input view and the key and return the result.
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}