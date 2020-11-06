package com.example.kannada;

public class Word {
    private String mDefaultTranslation;
    private String mKannadaTranslation;
    private int mImageResourceId =NO_IMAGE;
    private static final int NO_IMAGE=-1;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String kannadaTranslation,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mKannadaTranslation = kannadaTranslation;
      mAudioResourceId= audioResourceId;

    }

    public Word(String defaultTranslation, String kannadaTranslation ,int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mKannadaTranslation = kannadaTranslation;
        mImageResourceId=imageResourceId;
        mAudioResourceId= audioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmKannadaTranslation() {
        return mKannadaTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
    public boolean hasImage () {
        return mImageResourceId != NO_IMAGE;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}