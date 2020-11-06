package com.example.kannada;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class NumbersActivity extends AppCompatActivity {

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
        words.add(new Word("Zero", "Sonne",R.drawable.number_one, R.raw.zero));
        words.add(new Word("One", "Ondu",R.drawable.number_one,R.raw.one));
        words.add(new Word("Two", "Erodu",R.drawable.number_two,R.raw.two));
        words.add(new Word("Three", "Muru",R.drawable.number_three,R.raw.three));
        words.add(new Word("Four", "Nalku",R.drawable.number_four,R.raw.four));
        words.add(new Word("Five", "Aidu",R.drawable.number_five,R.raw.five));
        words.add(new Word("Six", "Aru",R.drawable.number_six,R.raw.six));
        words.add(new Word("Seven", "Elu",R.drawable.number_seven,R.raw.seven));
        words.add(new Word("Eight", "Entu",R.drawable.number_eight,R.raw.eight));
        words.add(new Word("Nine", "Ombattu",R.drawable.number_nine,R.raw.nine));
        words.add(new Word("Ten", "Hattu",R.drawable.number_ten,R.raw.ten));
        words.add(new Word("Hundred", "Nuru",R.drawable.number_ten,R.raw.hundred));
        WordAdapter adapter = new WordAdapter(this, words,R.color.colorOrange);

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
               mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
               mMediaPlayer.start();
               mMediaPlayer.setOnCompletionListener(mCompletionListener
               );
            }
        });

    }
    private void releaseMediaplayer() {
        //if media player is not null, then it may be laying current song
        if(mMediaPlayer !=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
        }

    }
}