package com.totoro_fly.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FamilyActivity extends AppCompatActivity {


    @Bind(R.id.word_list_view)
    ListView wordListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ButterKnife.bind(this);
        ArrayList<Word> family = new ArrayList<Word>();
        family.add(new Word("father", "epe"));
        family.add(new Word("mother", "eta"));
        family.add(new Word("son", "angsi"));
        family.add(new Word("daughter", "tune"));
        family.add(new Word("older brother", "taachi"));
        family.add(new Word("younger brother", "chalitti"));
        family.add(new Word("older sister", "tete"));
        family.add(new Word("younger sister", "kolliti"));
        family.add(new Word("grandmother", "ama"));
        family.add(new Word("grandfather", "paapa"));
        WordAdapter wordAdapter = new WordAdapter(this, family);
        wordListView.setAdapter(wordAdapter);
    }
}
