package com.example.kannada;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaplayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create an array
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red", "Kempu",R.drawable.color_red,R.raw.red));
       words.add(new Word("Orange","Kittale",R.drawable.color_red,R.raw.orange));
       words.add(new Word("Yellow","Haladi",R.drawable.color_mustard_yellow,R.raw.yellow));
       words.add(new Word("Green","Hasiru",R.drawable.color_green,R.raw.green));
       words.add(new Word("Blue","Neeli",R.drawable.color_white,R.raw.blue));
       words.add(new Word("Brown","Kandu",R.drawable.color_brown,R.raw.brown));
       words.add(new Word("Black","Kappu",R.drawable.color_black,R.raw.black));
       words.add(new Word("White","Bili",R.drawable.color_white,R.raw.white));
       words.add(new Word("Gray","Budu",R.drawable.color_gray,R.raw.gray));
       words.add(new Word("purple","Nerale",R.drawable.color_gray,R.raw.purple));
              WordAdapter adapter = new WordAdapter(this, words,R.color.colorGreen);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        //set a click listener to play audio when the list item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Get the {link Word} object at the given position user clicked on
                Word word = words.get(position);
                releaseMediaplayer();
                //create the setup the {link mediaplayer} for the audio resource associated with current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }
    private void releaseMediaplayer() {
        //if media player is not null, then it may be laying current song
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}