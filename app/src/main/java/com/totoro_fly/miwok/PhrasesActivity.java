package com.totoro_fly.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PhrasesActivity extends AppCompatActivity {


    @Bind(R.id.word_list_view)
    ListView wordListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ButterKnife.bind(this);
        ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("Where are you going?", "minto wuksus"));
        phrases.add(new Word("What is your name?", "tinne oyaase'ne"));
        phrases.add(new Word("My name is...", "oyaaset"));
        phrases.add(new Word("How are you feeling?", "michekses"));
        phrases.add(new Word("I'm feeling good.", "kuchi achit"));
        phrases.add(new Word("Are you coming?", "eenes'aa?"));
        phrases.add(new Word("Yes,I'm coming.", "hee'eenem"));
        phrases.add(new Word("I'm coming.", "eenem"));
        phrases.add(new Word("Let's go.", "yoowutis"));
        phrases.add(new Word("Come here", "anni'nem"));
        WordAdapter wordAdapter = new WordAdapter(this, phrases, R.color.phrases_background);
        wordListView.setAdapter(wordAdapter);
    }
}
