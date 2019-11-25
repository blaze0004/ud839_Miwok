package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int backgroundColor;

    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> words, int backgroundColor) {
        super(context, 0, words);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        LinearLayout listLinearLayout = (LinearLayout) listItemView.findViewById(R.id.listLinearLayout);
        TextView miwokTranslationWord = (TextView) listItemView.findViewById(R.id.miwokTranslationWord);
        TextView defaultTranslationWord = (TextView) listItemView.findViewById(R.id.defaultTranslationWord);
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        listLinearLayout.setBackgroundResource(this.backgroundColor);

        miwokTranslationWord.setText(currentWord.getmMiwokTranslation());
        defaultTranslationWord.setText(currentWord.getmDefaultTranslation());

        if (currentWord.hasImage()) {
            image.setImageResource(currentWord.getmImageResourceId());

            image.setVisibility(View.VISIBLE);

        } else {
            image.setVisibility(View.GONE);
        }


        return listItemView;
    }
}
