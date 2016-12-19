package com.totoro_fly.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ColorsActivity extends AppCompatActivity {


    @Bind(R.id.word_list_view)
    ListView wordListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ButterKnife.bind(this);
        ArrayList<Word> color = new ArrayList<Word>();
        color.add(new Word(R.drawable.color_red,"red", "wetetti"));
        color.add(new Word(R.drawable.color_green,"green", "chokokki"));
        color.add(new Word(R.drawable.color_brown,"brown", "takaakki"));
        color.add(new Word(R.drawable.color_gray,"gray", "topoppi"));
        color.add(new Word(R.drawable.color_black,"black", "kululli"));
        color.add(new Word(R.drawable.color_white,"white", "kelelli"));
        color.add(new Word(R.drawable.color_dusty_yellow,"dusty yellow", "topiise"));
        color.add(new Word(R.drawable.color_mustard_yellow,"mustard yellow", "chiwiite"));
        WordAdapter wordAdapter = new WordAdapter(this, color,R.color.color_background);
        wordListView.setAdapter(wordAdapter);
    }
}
