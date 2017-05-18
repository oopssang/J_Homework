package com.test.oopssang.j_homework.network;

import com.test.oopssang.j_homework.data.kakao.KakaoData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sang on 2017-05-17.
 */

interface KakaoImageService {
    @GET("search/image")
    Call<KakaoData> getdata(@Query("apikey") String apikey, @Query("output") String output, @Query("result") int result, @Query("q") String search);
}
