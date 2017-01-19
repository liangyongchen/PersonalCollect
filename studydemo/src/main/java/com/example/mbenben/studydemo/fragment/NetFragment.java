package com.example.mbenben.studydemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mbenben.studydemo.App;
import com.example.mbenben.studydemo.R;
import com.example.mbenben.studydemo.base.CommonAdapter;
import com.example.mbenben.studydemo.base.OnItemClickListener;
import com.example.mbenben.studydemo.base.ViewHolder;
import com.example.mbenben.studydemo.net.httpurl.HttpUrlAcitvity;
import com.example.mbenben.studydemo.net.okhttp.OkHttpDemoActivity;
import com.example.mbenben.studydemo.net.retrofit.RetrofitActivity;
import com.example.mbenben.studydemo.net.rxjava.RxJavaActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MBENBEN on 2017/1/17.
 */

public class NetFragment extends Fragment{
    @BindView(R.id.rlv_main) RecyclerView rlvMain;
    @BindView(R.id.tv_desc) TextView tvDesc;

    private static final String KEY="net";
    private List<String> datas=new ArrayList<>();
    private Map<String,String> map=new HashMap<>();

    private CommonAdapter<String> adapter;
    public static NetFragment newInstance(String desc) {
        
        Bundle args = new Bundle();
        args.putString(KEY,desc);
        NetFragment fragment = new NetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_main_layout,container,false);
        initView(view);
        initRlv();
        return view;
    }

    private void initRlv() {
        adapter=new CommonAdapter<String>(App.getInstance().getContext(),R.layout.item_info,datas) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.id_info,map.get(s));
            }
        };
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                switch (o.toString()) {
                    case "OkHttpDemoActivity":
                        Intent intentOkHttp=new Intent(App.getInstance().getContext(), OkHttpDemoActivity.class);
                        startActivity(intentOkHttp);
                        break;
                    case "HttpUrlActivity":
                        Intent intentHttpUrl=new Intent(App.getInstance().getContext(), HttpUrlAcitvity.class);
                        startActivity(intentHttpUrl);
                        break;
                    case "RetrofitActivity":
                        Intent intentRetrofit=new Intent(App.getInstance().getContext(), RetrofitActivity.class);
                        startActivity(intentRetrofit);
                        break;
                    case "RxJavaActivity":
                        Intent intentRxJava=new Intent(App.getInstance().getContext(), RxJavaActivity.class);
                        startActivity(intentRxJava);
                        break;
                }
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });
        rlvMain.setAdapter(adapter);
    }

    private void initView(View view) {
        ButterKnife.bind(this,view);

        rlvMain.setLayoutManager(new LinearLayoutManager(App.getInstance().getContext()));

        Bundle bundle = getArguments();
        String string = bundle.getString(KEY);
        tvDesc.setText(string);

        datas.add("HttpUrlActivity");
        map.put("HttpUrlActivity","使用HttpUrlConnection实现上传下载");

        datas.add("OkHttpDemoActivity");
        map.put("OkHttpDemoActivity","使用OkHttp实现上传下载");

        datas.add("RetrofitActivity");
        map.put("RetrofitActivity","使用Retrofit实现上传下载");

        datas.add("RxJavaActivity");
        map.put("RxJavaActivity","RxJava+Retrofit实例");

    }
}