package com.test.oopssang.j_homework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.test.oopssang.j_homework.adapter.RecyclerAdapter;
import com.test.oopssang.j_homework.data.viewdata.ViewData;
import com.test.oopssang.j_homework.network.CallBack;
import com.test.oopssang.j_homework.network.KaKaoIamge;
import com.test.oopssang.j_homework.network.NaverIamge;
import com.test.oopssang.j_homework.view.MySpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mSearchView;
    private EditText mEditText;
    private RelativeLayout mLoading;
    private RecyclerAdapter mRecyclerAdapter;
    private RecyclerView mRecyclerView;

    private ArrayList<ViewData> mListData;
    private GridLayoutManager mLayoutManager;
    private MySpinner mMySpinner;
    private String mSearch;

    private KaKaoIamge mKaKaoIamge;
    private NaverIamge mNaverIamge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();
        setIamgeService();
    }

    /**
     * 레이아웃 구성
     */
    private void setLayout() {
        mLoading = (RelativeLayout) findViewById(R.id.loading);
        mSearchView = (ImageView) findViewById(R.id.search_btn);
        mEditText = (EditText) findViewById(R.id.search_edit);
        mRecyclerView = (RecyclerView) findViewById(R.id.listview);
        mLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mMySpinner = (MySpinner) findViewById(R.id.my_spinner);
        mMySpinner.setAdapter(MainActivity.this);

        mSearchView.setOnClickListener(this);

        mRecyclerAdapter = new RecyclerAdapter(MainActivity.this);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    private void setIamgeService(){
        mKaKaoIamge = new KaKaoIamge(new CallBack() {
            @Override
            public void getViewData(ArrayList<ViewData> viewData) {
                Log.d("sang", "sang test KaKaoIamge");
                mRecyclerAdapter.setData(viewData);
                mRecyclerAdapter.notifyDataSetChanged();
                mLoading.setVisibility(View.INVISIBLE);
            }
        });

        mNaverIamge = new NaverIamge(new CallBack() {
            @Override
            public void getViewData(ArrayList<ViewData> viewData) {
                Log.d("sang", "sang test NaverIamge");
                mRecyclerAdapter.setData(viewData);
                mRecyclerAdapter.notifyDataSetChanged();
                mLoading.setVisibility(View.INVISIBLE);
            }
        });
    }

    /**
     * 이미지 API 연동
     * onResponse()를 통해 응답결과가 리턴 된다.
     */
    private void startRetrofit(String search) {
        mLoading.setVisibility(View.VISIBLE);

        switch (mMySpinner.getSearchMode() ){
            case "daum":
                mKaKaoIamge.startRetrofit(search);
                break;
            case "naver":
                mNaverIamge.startRetrofit(search);
                break;

        }
    }


    @Override
    public void onClick(View v) {
        Log.d("sang", "onClick");
        switch (v.getId()) {
            case R.id.search_btn: {
                if (mEditText != null && mEditText.getText() != null && mEditText.getText().length() != 0) {
                    mListData = null;
                    mSearch = mEditText.getText().toString();
                    startRetrofit(mSearch);
                }
            }
            default:
        }
    }
}
