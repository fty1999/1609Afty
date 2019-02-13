package com.bawei.com.yuekaofinal.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/19 09:00:08
 * @Description:
 */
public class HttpUtils{

    public static void httpAsyncTask(String strUrl, final CallBackString backString){
        new AsyncTask<String,Integer,String>(){

            @Override
            protected String doInBackground(String... strings) {
                return httpGet(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backString.getData(s);
            }
        }.execute(strUrl);
    }

    public interface CallBackString{
        void getData(String s);
    }
    public static String httpGet(String strUrl){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            String str="";
            while ((str=reader.readLine())!=null){
                builder.append(str);
            }
            connection.disconnect();
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //判断有没有网络
    public static boolean isNet(Context context){
        if (context!=null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info!=null){
                return info.isAvailable();
            }
        }
        return false;
    }
}
