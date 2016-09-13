package com.example.administrator.mvpframe.common.inter;

import com.example.administrator.mvpframe.fuc.main.entity.JokeEntity;
import com.example.administrator.mvpframe.fuc.main.entity.NewsTopEntity;
import com.example.administrator.mvpframe.fuc.main.entity.WeiChatEntity;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ConnectService {

    @FormUrlEncoded
    @POST("toutiao/index")
    Observable<NewsTopEntity> getNewTopList(@FieldMap Map<String,String> params);

    @GET("http://japi.juhe.cn/joke/content/list.from")
    Observable<JokeEntity> getJokeList(@QueryMap Map<String,String> params);

    @FormUrlEncoded
    @POST("weixin/query")
    Observable<WeiChatEntity> getWeiChatList(@FieldMap Map<String,String> params);

}
