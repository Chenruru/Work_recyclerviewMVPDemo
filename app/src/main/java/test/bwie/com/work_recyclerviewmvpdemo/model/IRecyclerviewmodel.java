package test.bwie.com.work_recyclerviewmvpdemo.model;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import test.bwie.com.work_recyclerviewmvpdemo.bean.Userbean;

/**
 * date: 2017/6/14
 * author:陈茹
 * 类的用途:
 */

public class IRecyclerviewmodel implements Recyclerviewmodel{


    public static  String url="http://www.tngou.net/api/info/list";

    Recyclerviewlistner recyclerviewlistner;
    public IRecyclerviewmodel(Recyclerviewlistner recyclerviewlistner){
        this.recyclerviewlistner=recyclerviewlistner;
    }

    @Override
    public void getdata() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                //失败
                recyclerviewlistner.onfailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String s = response.body().string();

                Gson gson=new Gson();
                Userbean userbean = gson.fromJson(s, Userbean.class);
                List<Userbean.TngouBean> request= userbean.getTngou();



                //成功
                recyclerviewlistner.onsuccess(request);

            }
        });

    }

    public interface Recyclerviewlistner{

        public void onsuccess(List<Userbean.TngouBean> request);
        public void onfailed();

    }
}
