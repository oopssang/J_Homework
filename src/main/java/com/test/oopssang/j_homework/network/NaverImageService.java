package com.test.oopssang.j_homework.network;


import com.test.oopssang.j_homework.data.naver.NaverData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by sang on 2017-05-17.
 */

interface NaverImageService {
    @Headers({
            "X-Naver-Client-Id: d9Lua62I49wMLufONbwB",
            "X-Naver-Client-Secret: ePyapKYHet"
    })
    @GET("search/image.json")
    Call<NaverData> getdata(@Query("query") String search, @Query("display") int display);

}
