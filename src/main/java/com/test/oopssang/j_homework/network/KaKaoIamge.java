package com.test.oopssang.j_homework.network;

import android.support.annotation.NonNull;
import android.util.Log;

import com.test.oopssang.j_homework.data.kakao.Item;
import com.test.oopssang.j_homework.data.kakao.KakaoData;
import com.test.oopssang.j_homework.data.viewdata.ViewData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sang on 2017-05-18.
 */

public class KaKaoIamge extends ImageData{
    private final String KAKAO_APIKEY = "6e4b5f46f7166da9b9c7d41d1e63294c";
    private final String KAKAO_API_RESULT_TYPE = "json";
    private final int KAKAO_IAMAGE_COUNT = 20;

    private KakaoImageService mKakaoService = RetrofitManager.getKakaoImageService();
    private CallBack mCallBack;

    public KaKaoIamge(CallBack callBack){
        mCallBack = callBack;
    }

    @Override
    public void startRetrofit(String search) {
        mKakaoService.getdata(KAKAO_APIKEY, KAKAO_API_RESULT_TYPE, KAKAO_IAMAGE_COUNT, search).enqueue(KakaoCallBack);
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
            data.setImageUrl(item.getImage());
            data.setHeigth(Integer.parseInt(item.getHeight()));
            data.setWidth(Integer.parseInt(item.getWidth()));
            temp.add(data);
        }
        return temp;
    }

    private Callback KakaoCallBack = new Callback<KakaoData>() {
        @Override
        public void onResponse(Call<KakaoData> call, Response<KakaoData> response) {
            KakaoData result = response.body();
            Log.e("sang", "onResponse  ");
            if (result != null) {
                if(mCallBack != null){
                    mCallBack.getViewData(changeData(result.getChannel().getItem()));
                }
            } else {
                Log.e("sang", "onResponse Data null ");
            }
        }

        @Override
        public void onFailure(Call<KakaoData> call, Throwable t) {
            Log.d("sang", "sang test onFailure: " + t.getMessage());
        }
    };
}
