package com.example.shashwatsinha.fragmenttransition;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;


public class MainActivity extends ActionBarActivity implements LettersListFragment.OnClickLetterist {

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!getResources().getBoolean(R.bool.isTablet) || getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.top_frame, new LettersListFragment());
            ft.commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(String s) {
        if (!getResources().getBoolean(R.bool.isTablet) || getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.top_frame, new DisplayFragment().newInstance(s));
            ft.addToBackStack("DetailsAdded");
            ft.commit();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d("shashwat", "Delaying thread");
                    FragmentManager fm = getFragmentManager();
                    DisplayFragment df = (DisplayFragment) fm.findFragmentById(R.id.top_frame);
                    CustomTextView tv = df.getTextView();
                    ViewGroup.LayoutParams vp = (ViewGroup.LayoutParams) tv.getLayoutParams();
                    vp.height = 500;
                    vp.width = 500;
                    tv.setLayoutParams(vp);


                }
            }, 500);
        } else {
            FragmentManager fm = getFragmentManager();
            DisplayFragment df = (DisplayFragment) fm.findFragmentById(R.id.details_page_fragment);
            df.setText(s);
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (!fm.popBackStackImmediate())
            super.onBackPressed();
    }
}
