package com.totoro_fly.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ColorsActivity extends AppCompatActivity {


    @Bind(R.id.word_list_view)
    ListView wordListView;
    private MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (i == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if (i == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ButterKnife.bind(this);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        final ArrayList<Word> color = new ArrayList<Word>();
        color.add(new Word(R.drawable.color_red, "red", "wetetti", R.raw.color_red));
        color.add(new Word(R.drawable.color_green, "green", "chokokki", R.raw.color_green));
        color.add(new Word(R.drawable.color_brown, "brown", "takaakki", R.raw.color_brown));
        color.add(new Word(R.drawable.color_gray, "gray", "topoppi", R.raw.color_gray));
        color.add(new Word(R.drawable.color_black, "black", "kululli", R.raw.color_black));
        color.add(new Word(R.drawable.color_white, "white", "kelelli", R.raw.color_white));
        color.add(new Word(R.drawable.color_dusty_yellow, "dusty yellow", "topiise", R.raw.color_dusty_yellow));
        color.add(new Word(R.drawable.color_mustard_yellow, "mustard yellow", "chiwiite", R.raw.color_mustard_yellow));
        WordAdapter wordAdapter = new WordAdapter(this, color, R.color.color_background);
        wordListView.setAdapter(wordAdapter);
        wordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word colorWord = color.get(i);
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(ColorsActivity.this, colorWord.getmMusic());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }
}
