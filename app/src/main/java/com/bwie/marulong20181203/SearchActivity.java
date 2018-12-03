package com.bwie.marulong20181203;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditQuery;
    /**
     * 搜索
     */
    private TextView mSousuo;
    private ImageView mImgPic;
    private FlowLayout mFlowlayout;
    private List<String> list = new ArrayList<>();
    private SQLiteDatabase database;
    /**
     * 香奈儿
     */
    private TextView mXiangnaier;
    /**
     * 雅诗兰黛
     */
    private TextView mYashilandai;
    /**
     * 欧莱雅
     */
    private TextView mOulaiya;
    /**
     * 兰蔻
     */
    private TextView mLankou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        mSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                //获取输入框的值
                String s = mEditQuery.getText().toString();
                list.add(s);
                MyHelper myHelper = new MyHelper(SearchActivity.this);
                database = myHelper.getWritableDatabase();
                database.execSQL("insert into user(title) values(?)", new String[]{s});
                TextView textView = new TextView(SearchActivity.this);
                textView.setText(list.get(list.size() - 1));
                textView.setTextSize(30);
                textView.setTextColor(Color.RED);
                textView.setPadding(10, 10, 10, 10);
                mFlowlayout.addView(textView, params);
            }
        });
        mImgPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFlowlayout.removeAllViews();
                database.delete("user", null, null);
            }
        });
        mXiangnaier.setOnClickListener(this);
        mYashilandai.setOnClickListener(this);
        mOulaiya.setOnClickListener(this);
        mLankou.setOnClickListener(this);
        mFlowlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this,"点击了搜索",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initView() {
        mEditQuery = findViewById(R.id.edit_query);
        mSousuo = findViewById(R.id.sousuo);
        mImgPic = findViewById(R.id.img_pic);
        mFlowlayout = findViewById(R.id.flowlayout);
        mXiangnaier = findViewById(R.id.xiangnaier);
        mYashilandai = findViewById(R.id.yashilandai);
        mOulaiya = findViewById(R.id.oulaiya);
        mLankou = findViewById(R.id.lankou);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xiangnaier:
                Toast.makeText(SearchActivity.this,"点击了香奈儿",Toast.LENGTH_LONG).show();
                break;
            case R.id.yashilandai:
                Toast.makeText(SearchActivity.this,"点击了雅诗兰黛",Toast.LENGTH_LONG).show();
                break;
            case R.id.oulaiya:
                Toast.makeText(SearchActivity.this,"点击了欧莱雅",Toast.LENGTH_LONG).show();
                break;
            case R.id.lankou:
                Toast.makeText(SearchActivity.this,"点击了兰蔻",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
