package com.yingshibao.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private MyAdapter mMyAdapter;

    private List<DataModel> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        mMyAdapter = new MyAdapter(datas);
        mRecyclerView.setAdapter(mMyAdapter);
        mMyAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, DataModel dataModel) {
                Toast.makeText(MainActivity.this, dataModel.getData(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            DataModel dataModel = new DataModel();
            dataModel.setData(i + "");
            datas.add(dataModel);
        }
    }
}
