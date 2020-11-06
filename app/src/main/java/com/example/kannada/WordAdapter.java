package com.example.kannada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class WordAdapter extends ArrayAdapter<Word> {
    private  int mColorResourceid;
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceid) {
        super(context, 0, words);
        mColorResourceid=colorResourceid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getmDefaultTranslation());
        TextView kannadaTextView = listItemView.findViewById(R.id.kannada_text_view);
        kannadaTextView.setText(currentWord.getmKannadaTranslation());
        ImageView imageView = listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getmImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }
         View textContainer =listItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),mColorResourceid);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
