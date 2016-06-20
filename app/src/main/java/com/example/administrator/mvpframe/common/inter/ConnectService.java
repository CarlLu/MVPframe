package com.example.administrator.mvpframe.common.inter;

import com.example.administrator.mvpframe.fuc.detail.model.TeacherInfoEntity;
import com.example.administrator.mvpframe.fuc.main.entity.EvaluateEntity;
import com.example.administrator.mvpframe.fuc.main.entity.MainTeacherEntity;
import com.example.administrator.mvpframe.fuc.main.entity.NewsEntity;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ConnectService {

    @FormUrlEncoded
    @POST("app/mechanism/findTeacher.do")
    Observable<MainTeacherEntity> getTeacherList(@Field("mechanismId") String mechanismId, @Field("pageNum") String pageNum);

    @FormUrlEncoded
    @POST("app/mechanism/findScore.do")
    Observable<EvaluateEntity> getEvaluateList(@Field("mechanismId") String mechanismId, @Field("pageNum") String pageNum);

    @FormUrlEncoded
    @POST("app/findMessage.do")
    Observable<NewsEntity> getNewsList(@Field("messageType") String messageType, @Field("loginType") String loginType, @Field("loginId") String loginId, @Field("pageNum") String pageNum);

    @FormUrlEncoded
    @POST("app/mechanism/getTeacher.do")
    Observable<TeacherInfoEntity> getDetailContent(@FieldMap Map<String,String> params);
}
