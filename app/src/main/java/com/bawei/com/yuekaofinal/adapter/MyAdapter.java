package com.bawei.com.yuekaofinal.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.com.yuekaofinal.R;
import com.bawei.com.yuekaofinal.bean.JsonBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/19 09:26:59
 * @Description:
 */
public class MyAdapter extends BaseAdapter {
    private List<JsonBean.DataBean> list;
    private Context context;

    public MyAdapter(List<JsonBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
//=========================================================================================

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)){
            case 0:
                ViewHolder1 holder1;
                if (view == null){
                    view = View.inflate(context, R.layout.item1,null);
                    holder1 = new ViewHolder1();
                    holder1.textView1 = view.findViewById(R.id.textView1);
                    holder1.imageView1 = view.findViewById(R.id.imageView1);
                    view.setTag(holder1);
                }else {
                    holder1 = (ViewHolder1) view.getTag();
                }
                JsonBean.DataBean bean = list.get(i);
                holder1.textView1.setText(bean.getNews_title());
                ImageLoader.getInstance().displayImage(bean.getPic_url(),holder1.imageView1);
                break;
            case 1:
                ViewHolder2 holder2;
                if (view == null){
                    view = View.inflate(context, R.layout.item2,null);
                    holder2 = new ViewHolder2();
                    holder2.textView2 = view.findViewById(R.id.textView2);
                    holder2.imageView2 = view.findViewById(R.id.imageView2);
                    view.setTag(holder2);
                }else {
                    holder2 = (ViewHolder2) view.getTag();
                }
                JsonBean.DataBean bean1 = list.get(i);
                holder2.textView2.setText(bean1.getNews_title());
                ImageLoader.getInstance().displayImage(bean1.getPic_url(),holder2.imageView2);
                break;
        }
        return view;
    }
    class ViewHolder1{
        TextView textView1;
        ImageView imageView1;
    }
    class ViewHolder2{
        TextView textView2;
        ImageView imageView2;
    }
}
