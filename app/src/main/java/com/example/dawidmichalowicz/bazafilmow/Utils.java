package com.example.dawidmichalowicz.bazafilmow;

/**
 * Created by Dawid Michałowicz on 20.04.2017.
 */

class Utils {
    static int chooseImage(String genre){
        int imageId;
        switch(genre){
            case "Action":
                imageId=R.drawable.action;
                break;
            case "Science Fiction":
                imageId=R.drawable.scifi;
                break;
            case "Animation":
                imageId=R.drawable.animation;
                break;
            default:
                imageId=R.drawable.eye;
                break;
        }
        return imageId;
    }

}
