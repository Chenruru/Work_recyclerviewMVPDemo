package test.bwie.com.work_recyclerviewmvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import test.bwie.com.work_recyclerviewmvpdemo.adapter.MyAdapter;
import test.bwie.com.work_recyclerviewmvpdemo.bean.Userbean;
import test.bwie.com.work_recyclerviewmvpdemo.prepersent.Recyclerviewprepersent;
import test.bwie.com.work_recyclerviewmvpdemo.view.IRecyclerview;

public class MainActivity extends AppCompatActivity implements IRecyclerview {

    private RecyclerView recyclerview_id;
    private Recyclerviewprepersent recyclerviewprepersent;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview_id = (RecyclerView) findViewById(R.id.recyclerview_id);


        recyclerviewprepersent = new Recyclerviewprepersent(this);
        recyclerviewprepersent.getdatasuccess();
    }



    @Override
    public void success(final List<Userbean.TngouBean> request) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new MyAdapter(MainActivity.this,request);
                recyclerview_id.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                recyclerview_id.setAdapter(adapter);

            }
        });
    }

    @Override
    public void faild() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {


            }
        });
    }
}
