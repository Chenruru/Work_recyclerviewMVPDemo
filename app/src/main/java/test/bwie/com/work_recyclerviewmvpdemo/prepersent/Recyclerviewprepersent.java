package test.bwie.com.work_recyclerviewmvpdemo.prepersent;

import java.util.List;

import test.bwie.com.work_recyclerviewmvpdemo.bean.Userbean;
import test.bwie.com.work_recyclerviewmvpdemo.model.IRecyclerviewmodel;
import test.bwie.com.work_recyclerviewmvpdemo.view.IRecyclerview;

/**
 * date: 2017/6/14
 * author:陈茹
 * 类的用途:
 */

public class Recyclerviewprepersent implements IRecyclerviewmodel.Recyclerviewlistner {

    IRecyclerviewmodel iRecyclerviewmodel;
    IRecyclerview iRecyclerview;
    public Recyclerviewprepersent(IRecyclerview iRecyclerview){
        this.iRecyclerview=iRecyclerview;
        iRecyclerviewmodel=new IRecyclerviewmodel(this);
    }

    //得到model层的网络请求数据
    public void getdatasuccess(){
        iRecyclerviewmodel.getdata();
    }

    @Override
    public void onsuccess(List<Userbean.TngouBean> request) {
        //如果请求出来的数据不为空
        if (request!=null){
            iRecyclerview.success(request);
        }
    }

    @Override
    public void onfailed() {

        iRecyclerview.faild();
    }
}
