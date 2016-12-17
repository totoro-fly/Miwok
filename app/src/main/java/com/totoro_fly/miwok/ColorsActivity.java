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
        color.add(new Word("red", "wetetti"));
        color.add(new Word("green", "chokokki"));
        color.add(new Word("brown", "takaakki"));
        color.add(new Word("gray", "topoppi"));
        color.add(new Word("black", "kululli"));
        color.add(new Word("white", "kelelli"));
        color.add(new Word("dusty yellow", "topiise"));
        color.add(new Word("mustard yellow", "chiwiite"));
        WordAdapter wordAdapter = new WordAdapter(this, color);
        wordListView.setAdapter(wordAdapter);
    }
}
