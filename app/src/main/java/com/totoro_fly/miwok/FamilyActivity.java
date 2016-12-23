package com.totoro_fly.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FamilyActivity extends AppCompatActivity {


    @Bind(R.id.word_list_view)
    ListView wordListView;
    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ButterKnife.bind(this);
        final ArrayList<Word> family = new ArrayList<Word>();
        family.add(new Word(R.drawable.family_father, "father", "epe", R.raw.family_father));
        family.add(new Word(R.drawable.family_mother, "mother", "eta", R.raw.family_mother));
        family.add(new Word(R.drawable.family_son, "son", "angsi", R.raw.family_son));
        family.add(new Word(R.drawable.family_daughter, "daughter", "tune", R.raw.family_daughter));
        family.add(new Word(R.drawable.family_older_brother, "older brother", "taachi", R.raw.family_older_brother));
        family.add(new Word(R.drawable.family_younger_brother, "younger brother", "chalitti", R.raw.family_younger_brother));
        family.add(new Word(R.drawable.family_older_sister, "older sister", "tete", R.raw.family_older_sister));
        family.add(new Word(R.drawable.family_younger_sister, "younger sister", "kolliti", R.raw.family_younger_sister));
        family.add(new Word(R.drawable.family_grandmother, "grandmother", "ama", R.raw.family_grandmother));
        family.add(new Word(R.drawable.family_grandfather, "grandfather", "paapa", R.raw.family_grandfather));
        WordAdapter wordAdapter = new WordAdapter(this, family, R.color.family_background);
        wordListView.setAdapter(wordAdapter);
        wordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word familyWord = family.get(i);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, familyWord.getmMusic());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
}
