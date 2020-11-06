package com.example.kannada;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingsAcitvity extends AppCompatActivity {
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
        words.add(new Word("Good Morning", "Subhodaya",R.raw.goodmorning));
        words.add(new Word("Good Afternoon", "Subha Aparahna",R.raw.goodnoon));
        words.add(new Word("Good Evening", "Subha Sanje",R.raw.goodevening));
        words.add(new Word("Hello", "Namaskara",R.raw.hello));
        words.add(new Word("Thank You", "Dhanyavada",R.raw.thankyou));
        words.add(new Word("Sorry", "Ksamisi",R.raw.sorry));
        words.add(new Word("please", "Dayavattu",R.raw.please));
        words.add(new Word("Welcome", "Swagata",R.raw.welcome));
        words.add(new Word("GoodBye", "Vidaya",R.raw.goodbye));
        words.add(new Word("Good Luck", "Olleyadagali",R.raw.bestluck));
        words.add(new Word("Happy Birthday ", "Huttuhabbada subhasayagali",R.raw.hbd));
        words.add(new Word("It's nice to meet you'", "Ninnannu Bhetiyagiddu Tumba santosha",R.raw.nicetomeetyou));

        WordAdapter adapter = new WordAdapter(this, words,R.color.colorRed);

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
                mMediaPlayer = MediaPlayer.create(GreetingsAcitvity.this, word.getAudioResourceId());
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