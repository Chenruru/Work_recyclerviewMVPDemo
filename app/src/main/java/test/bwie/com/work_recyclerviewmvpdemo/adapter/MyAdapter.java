package test.bwie.com.work_recyclerviewmvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.work_recyclerviewmvpdemo.R;
import test.bwie.com.work_recyclerviewmvpdemo.bean.Userbean;

/**
 * date: 2017/6/14
 * author:陈茹
 * 类的用途:
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Userbean.TngouBean> request;
    private Context context;
    public MyAdapter(Context context, List<Userbean.TngouBean> request){
        this.context=context;
        this.request=request;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.invitation_item, parent,
                false));
        return holder;

    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

     holder.textview_name.setText(request.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return request.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
       private  TextView textview_name;
        public MyViewHolder(View itemView) {
            super(itemView);

            textview_name = (TextView) itemView.findViewById(R.id.textview_name);

        }
    }
}
