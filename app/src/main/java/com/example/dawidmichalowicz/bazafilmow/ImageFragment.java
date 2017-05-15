package com.example.dawidmichalowicz.bazafilmow;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Dawid Michałowicz on 14.05.2017.
 */

public class ImageFragment extends Fragment {
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView[] imageViews;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.images_fragment, container, false);
        image1 = (ImageView) view.findViewById(R.id.imageView);
        image2 = (ImageView) view.findViewById(R.id.imageView2);
        image3 = (ImageView) view.findViewById(R.id.imageView3);
        image4 = (ImageView) view.findViewById(R.id.imageView4);
        image5 = (ImageView) view.findViewById(R.id.imageView5);
        image6 = (ImageView) view.findViewById(R.id.imageView6);
        imageViews = new ImageView[]{image1, image2, image3, image4, image5, image6};
        for (ImageView iv : imageViews) {
            setData(iv);
        }
        return view;
    }

    private void setData(ImageView iv) {
        TypedArray images = getResources().obtainTypedArray(R.array.loading_images);
        int choice = (int) (Math.random() * images.length());
        iv.setImageResource(images.getResourceId(choice, R.drawable.img1));
        images.recycle();

    }
}
