package com.totoro_fly.miwok;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

class MainActivity extends AppCompatActivity implements NumberFragment.OnFragmentInteractionListener, FamilyFragment.OnFragmentInteractionListener, ColorFragment.OnFragmentInteractionListener, PhrasesFragment.OnFragmentInteractionListener {
    @Bind(R.id.title_tabview)
    TabLayout titleTabview;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    //    @Bind(R.id.numbers_text_view)
//    TextView numbersTextView;
//    @Bind(R.id.family_text_view)
//    TextView familyTextView;
//    @Bind(R.id.colors_text_view)
//    TextView colorsTextView;
//    @Bind(R.id.phrases_text_view)
//    TextView phrasesTextView;
//    @Bind(R.id.activity_main)
//    LinearLayout activityMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(categoryAdapter);
        titleTabview.setupWithViewPager(viewPager);

    }

//    @OnClick({R.id.numbers_text_view, R.id.family_text_view, R.id.colors_text_view, R.id.phrases_text_view, R.id.activity_main})
//    public void onClick(View view) {
//        Intent intent;
//        switch (view.getId()) {
//            case R.id.numbers_text_view:
//                intent = new Intent(this, NumbersActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.family_text_view:
//                intent = new Intent(this, FamilyActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.colors_text_view:
//                intent = new Intent(this, ColorsActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.phrases_text_view:
//                intent = new Intent(this, PhrasesActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.activity_main:
//                break;
//        }
//    }

    @Override
    protected void onStart() {
        Log.d(MainActivity.class.getName(), "start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(MainActivity.class.getName(), "resume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(MainActivity.class.getName(), "pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(MainActivity.class.getName(), "stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(MainActivity.class.getName(), "destroy");
        super.onDestroy();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
