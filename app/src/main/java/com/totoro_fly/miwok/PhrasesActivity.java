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

public class PhrasesActivity extends AppCompatActivity {


    @Bind(R.id.word_list_view)
    ListView wordListView;
    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener()

    {
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ButterKnife.bind(this);
        final ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?", "tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is...", "oyaaset", R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?", "michekses", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?", "eenes'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes,I'm coming.", "hee'eenem", R.raw.phrase_im_coming));
        phrases.add(new Word("I'm coming.", "eenem", R.raw.phrase_yes_im_coming));
        phrases.add(new Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        phrases.add(new Word("Come here", "anni'nem", R.raw.phrase_come_here));
        WordAdapter wordAdapter = new WordAdapter(this, phrases, R.color.phrases_background);
        wordListView.setAdapter(wordAdapter);
        wordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word phrasesWord = phrases.get(i);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, phrasesWord.getmMusic());
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
