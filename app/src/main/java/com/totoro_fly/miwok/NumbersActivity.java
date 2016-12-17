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
        number.add(new Word("one", "lutti"));
        number.add(new Word("two", "otiiko"));
        number.add(new Word("three", "tolookosu"));
        number.add(new Word("four", "oyylsa"));
        number.add(new Word("five", "massokka"));
        number.add(new Word("six", "temmokka"));
        number.add(new Word("seven", "kenekaku"));
        number.add(new Word("eight", "kawinta"));
        number.add(new Word("nine", "wo e"));
        number.add(new Word("ten", "na aacha"));
        WordAdapter itemsAdapter = new WordAdapter(this, number);
        wordListView.setAdapter(itemsAdapter);
    }
}
