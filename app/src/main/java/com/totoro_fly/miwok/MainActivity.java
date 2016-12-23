package com.totoro_fly.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.numbers_text_view)
    TextView numbersTextView;
    @Bind(R.id.family_text_view)
    TextView familyTextView;
    @Bind(R.id.colors_text_view)
    TextView colorsTextView;
    @Bind(R.id.phrases_text_view)
    TextView phrasesTextView;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.numbers_text_view, R.id.family_text_view, R.id.colors_text_view, R.id.phrases_text_view, R.id.activity_main})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.numbers_text_view:
                intent = new Intent(this, NumbersActivity.class);
                startActivity(intent);
                break;
            case R.id.family_text_view:
                intent = new Intent(this, FamilyActivity.class);
                startActivity(intent);
                break;
            case R.id.colors_text_view:
                intent = new Intent(this, ColorsActivity.class);
                startActivity(intent);
                break;
            case R.id.phrases_text_view:
                intent = new Intent(this, PhrasesActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main:
                break;
        }
    }

    @Override
    protected void onStart() {
        Log.d(MainActivity.class.getName(),"start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(MainActivity.class.getName(),"resume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(MainActivity.class.getName(),"pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(MainActivity.class.getName(),"stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(MainActivity.class.getName(),"destroy");
        super.onDestroy();
    }
}
