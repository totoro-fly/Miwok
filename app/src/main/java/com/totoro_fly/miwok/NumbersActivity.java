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

public class NumbersActivity extends AppCompatActivity {


    @Bind(R.id.word_list_view)
    ListView wordListView;
    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListenter = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (i == AudioManager.AUDIOFOCUS_GAIN)
                mediaPlayer.start();
            else if (i == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ButterKnife.bind(this);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        final ArrayList<Word> number = new ArrayList<Word>();
        number.add(new Word(R.drawable.number_one, "one", "lutti", R.raw.number_one));
        number.add(new Word(R.drawable.number_two, "two", "otiiko", R.raw.number_two));
        number.add(new Word(R.drawable.number_three, "three", "tolookosu", R.raw.number_three));
        number.add(new Word(R.drawable.number_four, "four", "oyylsa", R.raw.number_four));
        number.add(new Word(R.drawable.number_five, "five", "massokka", R.raw.number_five));
        number.add(new Word(R.drawable.number_six, "six", "temmokka", R.raw.number_six));
        number.add(new Word(R.drawable.number_seven, "seven", "kenekaku", R.raw.number_seven));
        number.add(new Word(R.drawable.number_eight, "eight", "kawinta", R.raw.number_eight));
        number.add(new Word(R.drawable.number_nine, "nine", "wo e", R.raw.number_nine));
        number.add(new Word(R.drawable.number_ten, "ten", "na aacha", R.raw.number_ten));
        WordAdapter itemsAdapter = new WordAdapter(this, number, R.color.number_background);
        wordListView.setAdapter(itemsAdapter);
        wordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word numberWord = number.get(i);
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(mAudioFocusChangeListenter, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(NumbersActivity.this, numberWord.getmMusic());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
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
            audioManager.abandonAudioFocus(mAudioFocusChangeListenter);
        }
    }
}
