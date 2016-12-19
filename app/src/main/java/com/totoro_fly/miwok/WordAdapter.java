package com.totoro_fly.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by totoro-fly on 2016/12/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mListBackground;

    public WordAdapter(Context context, ArrayList<Word> word, int listBackground) {
        super(context, 0, word);
        mListBackground=listBackground;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word word = getItem(position);
        ImageView image = (ImageView) listItemView.findViewById(R.id.image_image_view);
        if (word.hasImage()) {
            image.setImageResource(word.getmImage());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(word.getMiwok());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(word.getEnglish());
        LinearLayout linearLayout= (LinearLayout) listItemView.findViewById(R.id.list_item_background_linearlayout);
        int color=ContextCompat.getColor(getContext(),mListBackground);
        linearLayout.setBackgroundColor(color);
        return listItemView;
    }
}
