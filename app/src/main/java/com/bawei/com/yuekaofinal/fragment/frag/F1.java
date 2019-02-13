package com.bawei.com.yuekaofinal.fragment.frag;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.com.yuekaofinal.R;
import com.bawei.com.yuekaofinal.adapter.MyAdapter;
import com.bawei.com.yuekaofinal.bean.JsonBean;
import com.bawei.com.yuekaofinal.http.HttpUtils;
import com.bawei.com.yuekaofinal.sql.Dao;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/18 19:05:41
 * @Description:
 */
public class F1 extends Fragment {

    private XListView xListView;
    private boolean b;
    private String str="http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private List<JsonBean.DataBean> data;
    private MyAdapter adapter;
    private Dao dao;
    private ArrayList<JsonBean.DataBean> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragone,container,false);
        xListView = view.findViewById(R.id.xlistview);
        xListView.setPullLoadEnable(true);
        b = HttpUtils.isNet(getActivity());
        dao = new Dao(getActivity());
        if (b){
            HttpUtils.httpAsyncTask(str, new HttpUtils.CallBackString() {
                @Override
                public void getData(String s) {
                    Gson gson = new Gson();
                    JsonBean bean = gson.fromJson(s, JsonBean.class);
                    data = bean.getData();
                    adapter = new MyAdapter(data,getActivity());
                    xListView.setAdapter(adapter);
                    onload();
                    if (dao.query("pp",null,null,null,null,null,null).moveToFirst()){

                    }else {
                        for (int i = 0;i<=data.size();i++){
                            ContentValues values = new ContentValues();
                            values.put("news_title",data.get(i).getNews_title());
                            values.put("pic_url",data.get(i).getPic_url());
                            dao.insert("pp",null,values);
                        }
                    }
                }
            });
        }else {
            Toast.makeText(getActivity(),"无网络连接，请检查网络设置",Toast.LENGTH_LONG).show();
            Cursor query = dao.query("pp", null, null, null, null, null, null);
            if (query.moveToFirst()){
                while (query.moveToNext()){
                    String news_title = query.getString(query.getColumnIndex("news_title"));
                    String pic_url = query.getString(query.getColumnIndex("pic_url"));
                    arrayList = new ArrayList<>();
                    arrayList.add(new JsonBean.DataBean(news_title,pic_url));
                }
                xListView.setAdapter(new MyAdapter(arrayList,getActivity()));
            }else {
                Toast.makeText(getActivity(),"无数据",Toast.LENGTH_LONG).show();
            }
        }
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                b = HttpUtils.isNet(getActivity());
                if (b){
                    HttpUtils.httpAsyncTask(str, new HttpUtils.CallBackString() {
                        @Override
                        public void getData(String s) {
                            Gson gson = new Gson();
                            JsonBean bean = gson.fromJson(s, JsonBean.class);
                            data = bean.getData();
                            adapter = new MyAdapter(data,getActivity());
                            xListView.setAdapter(adapter);
                            onload();
                            if (dao.query("pp",null,null,null,null,null,null).moveToFirst()){

                            }else {
                                for (int i = 0;i<=data.size();i++){
                                    ContentValues values = new ContentValues();
                                    values.put("news_title",data.get(i).getNews_title());
                                    values.put("pic_url",data.get(i).getPic_url());
                                    dao.insert("pp",null,values);
                                }
                            }
                        }
                    });
                }else {
                    Toast.makeText(getActivity(),"无网络连接，请检查网络设置",Toast.LENGTH_LONG).show();
                    Cursor query = dao.query("pp", null, null, null, null, null, null);
                    arrayList = new ArrayList<>();
                    if (query.moveToFirst()){
                        while (query.moveToNext()){
                            String news_title = query.getString(query.getColumnIndex("news_title"));
                            String pic_url = query.getString(query.getColumnIndex("pic_url"));

                            arrayList.add(new JsonBean.DataBean(news_title,pic_url));
                        }
                        xListView.setAdapter(new MyAdapter(arrayList,getActivity()));
                    }else {
                        Toast.makeText(getActivity(),"无数据",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onLoadMore() {
                b = HttpUtils.isNet(getActivity());
                if (b){
                    HttpUtils.httpAsyncTask(str, new HttpUtils.CallBackString() {
                        @Override
                        public void getData(String s) {
                            Gson gson = new Gson();
                            JsonBean bean = gson.fromJson(s, JsonBean.class);
                            List<JsonBean.DataBean> list = bean.getData();
                            data.addAll(list);
                            adapter = new MyAdapter(F1.this.data,getActivity());
                            xListView.setAdapter(adapter);
                            onload();
                            if (dao.query("pp",null,null,null,null,null,null).moveToFirst()){

                            }else {
                                for (int i = 0; i<= F1.this.data.size(); i++){
                                    ContentValues values = new ContentValues();
                                    values.put("news_title", F1.this.data.get(i).getNews_title());
                                    values.put("pic_url", F1.this.data.get(i).getPic_url());
                                    dao.insert("pp",null,values);
                                }
                            }
                        }
                    });
                }else {
                    Toast.makeText(getActivity(),"无网络连接，请检查网络设置",Toast.LENGTH_LONG).show();
                    Cursor query = dao.query("pp", null, null, null, null, null, null);
                    if (query.moveToFirst()){
                        while (query.moveToNext()){
                            String news_title = query.getString(query.getColumnIndex("news_title"));
                            String pic_url = query.getString(query.getColumnIndex("pic_url"));
                            arrayList = new ArrayList<>();
                            arrayList.add(new JsonBean.DataBean(news_title,pic_url));
                        }
                        xListView.setAdapter(new MyAdapter(arrayList,getActivity()));
                    }else {
                        Toast.makeText(getActivity(),"无数据",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return view;
    }
    public void onload(){
        xListView.stopRefresh();
        xListView.stopLoadMore();
        xListView.setRefreshTime("刷新");
    }
}
