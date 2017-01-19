package com.example.mbenben.studydemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.mbenben.studydemo.view.behavior.BehaviorActivity;
import com.example.mbenben.studydemo.view.bezier.ClearBezierActivity;
import com.example.mbenben.studydemo.view.bezier.GiftBezierActivity;
import com.example.mbenben.studydemo.view.chart.ChartActivity;
import com.example.mbenben.studydemo.view.credit.CreditActivity;
import com.example.mbenben.studydemo.view.enviews.ENViewsActivity;
import com.example.mbenben.studydemo.view.expandabletextview.ExpandableActivity;
import com.example.mbenben.studydemo.view.gradationtitle.QQTitleActivity;
import com.example.mbenben.studydemo.view.healthytables.HealthyTablesActivity;
import com.example.mbenben.studydemo.view.htmltext.HtmlTextActivity;
import com.example.mbenben.studydemo.view.lol.LoLActivity;
import com.example.mbenben.studydemo.view.passwordedittext.PassWordActivity;
import com.example.mbenben.studydemo.view.progressbar.ProgressBarActivity;
import com.example.mbenben.studydemo.view.qqhealth.QQHealthActivity;
import com.example.mbenben.studydemo.view.viscosity.ViscosityActivity;
import com.example.mbenben.studydemo.view.wave.WaveActivity;
import com.example.mbenben.studydemo.view.weibosport.WeiBoSportActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MBENBEN on 2017/1/17.
 */

public class ViewsFragment extends Fragment{
    @BindView(R.id.rlv_main) RecyclerView rlvMain;
    @BindView(R.id.tv_desc) TextView tvDesc;

    private static final String KEY="views";
    private List<String> datas=new ArrayList<>();
    private Map<String,String> map=new HashMap<>();

    private CommonAdapter<String> adapter;
    public static ViewsFragment newInstance(String desc) {

        Bundle args = new Bundle();
        args.putString(KEY,desc);
        ViewsFragment fragment = new ViewsFragment();
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
                switch (o.toString()){
                    case "ClearBezierActivity":
                        Intent intentNav=new Intent(App.getInstance().getContext(), ClearBezierActivity.class);
                        startActivity(intentNav);
                        break;
                    case "GiftBezierActivity":
                        Intent intentView=new Intent(App.getInstance().getContext(), GiftBezierActivity.class);
                        startActivity(intentView);
                        break;
                    case "HealthyTablesActivity":
                        Intent intentNestedScroll=new Intent(App.getInstance().getContext(), HealthyTablesActivity.class);
                        startActivity(intentNestedScroll);
                        break;
                    case "CreditActivity":
                        Intent intentPuzzle=new Intent(App.getInstance().getContext(), CreditActivity.class);
                        startActivity(intentPuzzle);
                        break;
                    case "WeiBoSportActivity":
                        Intent intentIndicator=new Intent(App.getInstance().getContext(), WeiBoSportActivity.class);
                        startActivity(intentIndicator);
                        break;
                    case "QQHealthActivity":
                        Intent intentDrawerLayout=new Intent(App.getInstance().getContext(), QQHealthActivity.class);
                        startActivity(intentDrawerLayout);
                        break;
                    case "ChartActivity":
                        Intent intentRecycler=new Intent(App.getInstance().getContext(), ChartActivity.class);
                        startActivity(intentRecycler);
                        break;
                    case "LoLActivity":
                        Intent intentViewPager=new Intent(App.getInstance().getContext(), LoLActivity.class);
                        startActivity(intentViewPager);
                        break;
                    case "WaveActivity":
                        Intent intentSwipeCards=new Intent(App.getInstance().getContext(), WaveActivity.class);
                        startActivity(intentSwipeCards);
                        break;
                    case "ViscosityActivity":
                        Intent intentEle=new Intent(App.getInstance().getContext(), ViscosityActivity.class);
                        startActivity(intentEle);
                        break;
                    case "ExpandableActivity":
                        Intent intentSelect=new Intent(App.getInstance().getContext(), ExpandableActivity.class);
                        startActivity(intentSelect);
                        break;
                    case "ENViewsActivity":
                        Intent intentMyButterKnife=new Intent(App.getInstance().getContext(), ENViewsActivity.class);
                        startActivity(intentMyButterKnife);
                        break;
                    case "QQTitleActivity":
                        Intent intentQQTitle=new Intent(App.getInstance().getContext(), QQTitleActivity.class);
                        startActivity(intentQQTitle);
                        break;
                    case "ProgressBarActivity":
                        Intent intentArcLayout=new Intent(App.getInstance().getContext(), ProgressBarActivity.class);
                        startActivity(intentArcLayout);
                        break;
                    case "HtmlTextActivity":
                        Intent intentMultiLineChoose=new Intent(App.getInstance().getContext(), HtmlTextActivity.class);
                        startActivity(intentMultiLineChoose);
                        break;
                    case "PassWordActivity":
                        Intent intentRickText=new Intent(App.getInstance().getContext(), PassWordActivity.class);
                        startActivity(intentRickText);
                        break;
                    case "BehaviorActivity":
                        Intent intentBehavior=new Intent(App.getInstance().getContext(), BehaviorActivity.class);
                        startActivity(intentBehavior);
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

        rlvMain.setLayoutManager(new GridLayoutManager(App.getInstance().getContext(),2));

        Bundle bundle = getArguments();
        String string = bundle.getString(KEY);
        tvDesc.setText(string);

        datas.add("ClearBezierActivity");
        map.put("ClearBezierActivity","贝塞尔曲线实现发生火箭的效果");

        datas.add("GiftBezierActivity");
        map.put("GiftBezierActivity","贝塞尔曲线实现发生直播平台送礼物的效果");

        datas.add("HealthyTablesActivity");
        map.put("HealthyTablesActivity","折线图效果");

        datas.add("CreditActivity");
        map.put("CreditActivity","支付宝信用效果");

        datas.add("WeiBoSportActivity");
        map.put("WeiBoSportActivity","圆形评分进度效果");

        datas.add("QQHealthActivity");
        map.put("QQHealthActivity","QQ步数效果");

        datas.add("ChartActivity");
        map.put("ChartActivity","柱状图效果");

        datas.add("LoLActivity");
        map.put("LoLActivity","LOL能力数值分析效果");

        datas.add("WaveActivity");
        map.put("WaveActivity","波浪动画实例");

        datas.add("ViscosityActivity");
        map.put("ViscosityActivity","仿QQ粘性消息拖拽效果");

        datas.add("ExpandableActivity");
        map.put("ExpandableActivity","可折叠式TextView");

        datas.add("BehaviorActivity");
        map.put("BehaviorActivity","Behavior实践：缩放式搜索框");

        datas.add("ENViewsActivity");
        map.put("ENViewsActivity","酷炫的小动画，如：加载..");

        datas.add("ProgressBarActivity");
        map.put("ProgressBarActivity","自定义ProgressBar（下载进度条）");

        datas.add("HtmlTextActivity");
        map.put("HtmlTextActivity","可以解析Html的TextView");

        datas.add("PassWordActivity");
        map.put("PassWordActivity","仿安全登录EditText");



    }
}