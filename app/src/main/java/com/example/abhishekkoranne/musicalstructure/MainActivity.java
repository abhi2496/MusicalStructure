package com.example.abhishekkoranne.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
//import com.example.abhishekkoranne.musicalstructure.R;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    LinearLayout nowPlayingDock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());

        nowPlayingDock = (LinearLayout) findViewById(R.id.nowPlayingDock);

        nowPlayingDock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songIntent = new Intent(MainActivity.this, SongActivity.class);
                startActivity(songIntent);
            }
        });

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_collections:
                    //mTextMessage.setText(R.string.title_collections);
                    fragment = new CategoryFragment();
                    break;
                case R.id.navigation_fav:
                    //mTextMessage.setText(R.string.title_fav);
                    fragment = new FavoriteFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    private boolean loadFragment (Fragment fragment){
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
