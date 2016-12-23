package com.totoro_fly.miwok;

/**
 * Created by totoro-fly on 2016/12/17.
 */

public class Word {

    private int mImage = NO_IMAGE_PROVIDE;
    private String mEnglish;
    private String mMiwok;
    private int mMusic;
    private static final int NO_IMAGE_PROVIDE = -1;

    public Word(String mEnglish, String mMiwok, int mMusic) {
        this.mEnglish = mEnglish;
        this.mMiwok = mMiwok;
        this.mMusic = mMusic;
    }

    public Word(String mEnglish, String mMiwok) {
        this.mEnglish = mEnglish;
        this.mMiwok = mMiwok;
    }

    public Word(int mImage, String mEnglish, String mMiwok) {
        this.mImage = mImage;
        this.mEnglish = mEnglish;
        this.mMiwok = mMiwok;
    }

    public Word(int mImage, String mEnglish, String mMiwok, int mMusic) {
        this.mImage = mImage;
        this.mEnglish = mEnglish;
        this.mMiwok = mMiwok;
        this.mMusic = mMusic;
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

    public int getmMusic() {
        return mMusic;
    }

    public boolean hasImage() {
        return mImage != NO_IMAGE_PROVIDE;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mImage=" + mImage +
                ", mEnglish='" + mEnglish + '\'' +
                ", mMiwok='" + mMiwok + '\'' +
                ", mMusic=" + mMusic +
                '}';
    }
}
