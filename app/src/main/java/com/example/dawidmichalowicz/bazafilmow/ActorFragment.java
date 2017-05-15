package com.example.dawidmichalowicz.bazafilmow;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dawid Michałowicz on 14.05.2017.
 */

public class ActorFragment extends Fragment {
    ImageView image1;
    ImageView image2;
    ImageView image3;
    TextView name1;
    TextView name2;
    TextView name3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.actor_fragment, container, false);
        image1 = (ImageView) view.findViewById(R.id.imageView7);
        image2 = (ImageView) view.findViewById(R.id.imageView8);
        image3 = (ImageView) view.findViewById(R.id.imageView9);
        name1 = (TextView) view.findViewById(R.id.textView);
        name2 = (TextView) view.findViewById(R.id.textView2);
        name3 = (TextView) view.findViewById(R.id.textView3);
        setData(image1, name1);
        setData(image2, name2);
        setData(image3, name3);
        return view;
    }

    private void setData(ImageView iv, TextView tv) {
        TypedArray images = getResources().obtainTypedArray(R.array.actor_images);
        String[] names = getResources().getStringArray(R.array.actor_names);

        int choiceImg = (int) (Math.random() * images.length());
        int choiceTxt = (int) (Math.random() * names.length);
        iv.setImageResource(images.getResourceId(choiceImg, R.drawable.img1));
        tv.setText(names[choiceTxt]);
        images.recycle();
    }

}
