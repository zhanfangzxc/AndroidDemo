package com.zss.girdwithheaderdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by zhaoshanshan on 15/10/14.
 */
public class SlidingMenuActivity extends Activity {

    private SlidingMenu mSlidingMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mSlidingMenu = (SlidingMenu) findViewById(R.id.id_menu);

    }

    public void toggleMenu(View view){
        mSlidingMenu.toggle();
    }
}
