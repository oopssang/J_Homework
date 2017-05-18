package com.test.oopssang.j_homework.network;

import android.support.annotation.NonNull;
import android.util.Log;

import com.test.oopssang.j_homework.data.naver.Item;
import com.test.oopssang.j_homework.data.naver.NaverData;
import com.test.oopssang.j_homework.data.viewdata.ViewData;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sang on 2017-05-18.
 */

public class NaverIamge extends ImageData{
    private NaverImageService mNaverImageService = RetrofitManager.getNaverImageService();
    private CallBack mCallBack;

    public NaverIamge(CallBack callBack){
        mCallBack = callBack;
    }

    @Override
    public void startRetrofit(String search) {
        String utf_8_search = "";
        try {
            utf_8_search = URLEncoder.encode(search, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.e("sang", "onResponse  utf_8_search  " + utf_8_search);
        mNaverImageService.getdata(utf_8_search, 20).enqueue(NaverCallBack);
    }

    /**
     * 서버응답값을 받아 화면에서 필요한 url / Width / Height 정보만을 가지고 있는 ViewData List로 리턴
     * @param t ArrayList<Item>
     * @return ArrayList<ViewData>
     */
    private ArrayList<ViewData> changeData(@NonNull ArrayList<Item> t) {
        ArrayList<ViewData> temp = new ArrayList<ViewData>();
        for(Item item : t){
            ViewData data = new ViewData();
            data.setImageUrl(item.getThumbnail());
            data.setHeigth(Integer.parseInt(item.getSizeheight()));
            data.setWidth(Integer.parseInt(item.getSizewidth()));
            temp.add(data);
        }
        return temp;
    }

    private Callback NaverCallBack = new Callback<NaverData>() {
        @Override
        public void onResponse(Call<NaverData> call, Response<NaverData> response) {
            NaverData result = response.body();
            Log.e("sang", "onResponse  ");
            if (result != null) {
                if(mCallBack != null){
                    mCallBack.getViewData(changeData(result.getItems()));
                }
            } else {
                Log.e("sang", "onResponse Data null ");
            }
        }

        @Override
        public void onFailure(Call<NaverData> call, Throwable t) {
            Log.d("sang", "sang test onFailure: " + t.getMessage());
        }
    };
}
