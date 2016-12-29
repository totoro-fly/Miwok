//package com.totoro_fly.miwok;
//
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//
//public class FamilyActivity extends AppCompatActivity implements FamilyFragment.OnFragmentInteractionListener{
//
////
////    @Bind(R.id.word_list_view)
////    ListView wordListView;
////    MediaPlayer mediaPlayer;
////    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
////        @Override
////        public void onCompletion(MediaPlayer mediaPlayer) {
////            releaseMediaPlayer();
////        }
////    };
////    AudioManager audioManager;
////    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
////
////        public void onAudioFocusChange(int i) {
////            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
////                mediaPlayer.pause();
////                mediaPlayer.seekTo(0);
////            } else if (i == AudioManager.AUDIOFOCUS_GAIN) {
////                mediaPlayer.start();
////            } else if (i == AudioManager.AUDIOFOCUS_LOSS) {
////                releaseMediaPlayer();
////            }
////        }
////    };
////
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_category);
//        getSupportFragmentManager().beginTransaction().replace(R.id.container,new FamilyFragment()).commit();
////        ButterKnife.bind(this);
////        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
////        final ArrayList<Word> family = new ArrayList<Word>();
////        family.add(new Word(R.drawable.family_father, "father", "epe", R.raw.family_father));
////        family.add(new Word(R.drawable.family_mother, "mother", "eta", R.raw.family_mother));
////        family.add(new Word(R.drawable.family_son, "son", "angsi", R.raw.family_son));
////        family.add(new Word(R.drawable.family_daughter, "daughter", "tune", R.raw.family_daughter));
////        family.add(new Word(R.drawable.family_older_brother, "older brother", "taachi", R.raw.family_older_brother));
////        family.add(new Word(R.drawable.family_younger_brother, "younger brother", "chalitti", R.raw.family_younger_brother));
////        family.add(new Word(R.drawable.family_older_sister, "older sister", "tete", R.raw.family_older_sister));
////        family.add(new Word(R.drawable.family_younger_sister, "younger sister", "kolliti", R.raw.family_younger_sister));
////        family.add(new Word(R.drawable.family_grandmother, "grandmother", "ama", R.raw.family_grandmother));
////        family.add(new Word(R.drawable.family_grandfather, "grandfather", "paapa", R.raw.family_grandfather));
////        WordAdapter wordAdapter = new WordAdapter(this, family, R.color.family_background);
////        wordListView.setAdapter(wordAdapter);
////        wordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                Word familyWord = family.get(i);
////                releaseMediaPlayer();
////                int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
////                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
////                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, familyWord.getmMusic());
////                    mediaPlayer.start();
////                    mediaPlayer.setOnCompletionListener(mCompletionListener);
////                }
////            }
////        });
//    }
//
//    @Override
//    public void onFragmentInteraction(Uri uri) {
//        
//    }
////
////    protected void onStop() {
////        super.onStop();
////        releaseMediaPlayer();
////    }
////
////    private void releaseMediaPlayer() {
////        if (mediaPlayer != null) {
////            mediaPlayer.release();
////            mediaPlayer = null;
////            audioManager.abandonAudioFocus(audioFocusChangeListener);
////        }
////
////    }
//}
