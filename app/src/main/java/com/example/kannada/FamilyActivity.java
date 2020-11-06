package com.example.kannada;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class FamilyActivity extends AppCompatActivity {
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
        words.add(new Word("GrandMother", "Ajji",R.drawable.family_grandmother,R.raw.grandmother));
        words.add(new Word("GrandFather", "Ajja",R.drawable.family_grandfather,R.raw.grandfather));
        words.add(new Word("Mother", "Tayi",R.drawable.family_mother,R.raw.mother));
        words.add(new Word("Father", "Tande",R.drawable.family_father,R.raw.father));
        words.add(new Word("Daughter", "Magalu",R.drawable.family_daughter,R.raw.daughter));
        words.add(new Word("Son", "Maga",R.drawable.family_son,R.raw.son));
        words.add(new Word("Younger Sister", "Tangi",R.drawable.family_younger_sister,R.raw.youngersistermp3));
        words.add(new Word("Elder Sister", "Akka",R.drawable.family_older_sister,R.raw.eldersister));
        words.add(new Word("Younger Brother", "Tamma",R.drawable.family_younger_brother,R.raw.youngerbrother));
        words.add(new Word("Elder Brother", "Anna",R.drawable.family_older_brother,R.raw.elderbrother));
        words.add(new Word("Cousin", "Sodarasambandhi",R.raw.cousin));
        words.add(new Word("Grandson", "Mommaga",R.raw.grandson));
        words.add(new Word("Granddaughter", "Mommagalu",R.raw.granddaughter));
        words.add(new Word("Niece", "Sodara sose",R.raw.niece));
        words.add(new Word("Nephew", "Sodara liya",R.raw.nephew));



        WordAdapter adapter = new WordAdapter(this, words,R.color.colorBlue);

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
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
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