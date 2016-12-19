package com.totoro_fly.miwok;

/**
 * Created by totoro-fly on 2016/12/17.
 */

public class Word {
    private int mImage = NO_IMAGE_PROVIDE;
    private String mEnglish;
    private String mMiwok;
    private static final int NO_IMAGE_PROVIDE = -1;


    public Word(String mEnglish, String mMiwok) {
        this.mEnglish = mEnglish;
        this.mMiwok = mMiwok;
    }

    public Word(int image, String english, String miwok) {
        mImage = image;
        mEnglish = english;
        mMiwok = miwok;
    }


    public int getmImage() {
        return mImage;
    }


    public String getEnglish() {
        return mEnglish;
    }

    public String getMiwok() {
        return mMiwok;
    }

    public boolean hasImage() {
        return mImage != NO_IMAGE_PROVIDE;
    }

}
