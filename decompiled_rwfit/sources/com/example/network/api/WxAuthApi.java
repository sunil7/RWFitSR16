package com.example.network.api;

import com.example.network.bean.WxAuthInfoBean;
import com.example.network.bean.WxUserInfoBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rg.l;

/* loaded from: classes.dex */
public interface WxAuthApi {
    @GET("oauth2/access_token")
    l<WxAuthInfoBean.AuthInfo> authWx(@Query("appid") String str, @Query("secret") String str2, @Query("code") String str3, @Query("grant_type") String str4);

    @GET("userinfo")
    l<WxUserInfoBean> getWxUserInfo(@Query("access_token") String str, @Query("openid") String str2);
}
