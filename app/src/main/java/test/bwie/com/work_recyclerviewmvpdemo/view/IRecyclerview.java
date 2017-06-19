package test.bwie.com.work_recyclerviewmvpdemo.view;

import java.util.List;

import test.bwie.com.work_recyclerviewmvpdemo.bean.Userbean;

/**
 * date: 2017/6/14
 * author:陈茹
 * 类的用途:
 */

public interface IRecyclerview {


    //请求成功
    public void success(List<Userbean.TngouBean> request);

    //请求失败
    public void faild();

}
