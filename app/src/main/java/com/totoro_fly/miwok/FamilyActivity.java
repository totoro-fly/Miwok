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
        family.add(new Word(R.drawable.family_father,"father", "epe"));
        family.add(new Word(R.drawable.family_mother,"mother", "eta"));
        family.add(new Word(R.drawable.family_son,"son", "angsi"));
        family.add(new Word(R.drawable.family_daughter,"daughter", "tune"));
        family.add(new Word(R.drawable.family_older_brother,"older brother", "taachi"));
        family.add(new Word(R.drawable.family_younger_brother,"younger brother", "chalitti"));
        family.add(new Word(R.drawable.family_older_sister,"older sister", "tete"));
        family.add(new Word(R.drawable.family_younger_sister,"younger sister", "kolliti"));
        family.add(new Word(R.drawable.family_grandmother,"grandmother", "ama"));
        family.add(new Word(R.drawable.family_grandfather,"grandfather", "paapa"));
        WordAdapter wordAdapter = new WordAdapter(this, family, R.color.family_background);
        wordListView.setAdapter(wordAdapter);
    }
}
