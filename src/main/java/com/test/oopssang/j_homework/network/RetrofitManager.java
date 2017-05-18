package com.test.oopssang.j_homework.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sang on 2017-05-17.
 */

class RetrofitManager{
    private final static String BASE_URL_KAKAO = "https://apis.daum.net/";
    private final static String BASE_URL_NAVER = "https://openapi.naver.com/v1/";

    /**
     * KakaoImageService 리턴.
     * @return
     */
    public static KakaoImageService getKakaoImageService(){
        StringBuilder builder = new StringBuilder();
        builder.append(BASE_URL_KAKAO);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(KakaoImageService.class);
    }

    /**
     * NaverImageService 리턴.
     * @return
     */
    public static NaverImageService getNaverImageService(){
        StringBuilder builder = new StringBuilder();
        builder.append(BASE_URL_NAVER);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(NaverImageService.class);
    }
}
