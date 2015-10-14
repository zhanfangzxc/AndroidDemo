package com.zss.girdwithheaderdemo;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

/**
 * Created by zhaoshanshan on 15/10/13.
 */
public class GridLayoutAutoFitActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_fit_recycler_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new MarginDecoration(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new NumberAdapter(30));
    }
}
