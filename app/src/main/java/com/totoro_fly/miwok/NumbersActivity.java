package com.totoro_fly.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NumbersActivity extends AppCompatActivity {


    @Bind(R.id.word_list_view)
    ListView wordListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ButterKnife.bind(this);
        ArrayList<Word> number = new ArrayList<Word>();
        number.add(new Word(R.drawable.number_one,"one", "lutti"));
        number.add(new Word(R.drawable.number_two,"two", "otiiko"));
        number.add(new Word(R.drawable.number_three,"three", "tolookosu"));
        number.add(new Word(R.drawable.number_four,"four", "oyylsa"));
        number.add(new Word(R.drawable.number_five,"five", "massokka"));
        number.add(new Word(R.drawable.number_six,"six", "temmokka"));
        number.add(new Word(R.drawable.number_seven,"seven", "kenekaku"));
        number.add(new Word(R.drawable.number_eight,"eight", "kawinta"));
        number.add(new Word(R.drawable.number_nine,"nine", "wo e"));
        number.add(new Word(R.drawable.number_ten,"ten", "na aacha"));
        WordAdapter itemsAdapter = new WordAdapter(this, number, R.color.number_background);
        wordListView.setAdapter(itemsAdapter);
    }
}
