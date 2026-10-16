package com.example.network.api;

import com.example.network.base.HttpModel;
import com.example.network.bean.AppVersionBean;
import com.example.network.bean.DocUrlBean;
import com.example.network.bean.LoginResultBean;
import com.example.network.bean.MemberFriendApplyBean;
import com.example.network.bean.MemberFriendBean;
import com.example.network.bean.MemberFriendDataBean;
import com.example.network.bean.SwitchBean;
import com.example.network.bean.UserInfoBean;
import java.util.List;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rg.l;

/* loaded from: classes.dex */
public interface UserApi {
    @FormUrlEncoded
    @POST("member/bind")
    l<HttpModel<UserInfoBean>> bindAccount(@Field("account") String str, @Field("password") String str2, @Field("verifyCode") String str3);

    @POST("data/clear")
    l<HttpModel<String>> clearData();

    @FormUrlEncoded
    @POST("member/delete")
    l<HttpModel<String>> delAccount(@Field("password") String str, @Field("verifyCode") String str2);

    @FormUrlEncoded
    @POST("member/saveFeedback")
    l<HttpModel<String>> feedback(@Field("desc") String str, @Field("pictureUrls") String str2, @Field("logUrls") String str3, @Field("contact") String str4, @Field("deviceModel") String str5, @Field("orderNo") String str6, @Field("memberId") String str7);

    @GET("member/appVersion")
    l<HttpModel<AppVersionBean>> getAppVersion(@Query("type") String str, @Query("version") String str2);

    @GET("member/getDocUrl")
    l<HttpModel<DocUrlBean>> getDocUrl(@Query("language") String str);

    @GET("member/getSwitch")
    l<HttpModel<List<SwitchBean>>> getSwitchParam();

    @GET("member/info")
    l<HttpModel<UserInfoBean>> getUserInfo();

    @FormUrlEncoded
    @POST("auth/login")
    l<HttpModel<LoginResultBean>> login(@Field("username") String str, @Field("password") String str2);

    @FormUrlEncoded
    @POST("member/logout")
    l<HttpModel<String>> logout(@Field("aa") String str);

    @FormUrlEncoded
    @POST("member/friend/agree")
    l<HttpModel<String>> memberFriendAgree(@Field("applyId") Integer num);

    @FormUrlEncoded
    @POST("member/friend/apply")
    l<HttpModel<String>> memberFriendApply(@Field("friendId") Integer num);

    @GET("member/friend/data")
    l<HttpModel<MemberFriendDataBean>> memberFriendData(@Query("friendId") Integer num, @Query("date") Long l3);

    @FormUrlEncoded
    @POST("member/friend/delete")
    l<HttpModel<String>> memberFriendDelete(@Field("friendId") Integer num);

    @GET("member/friend/getApplyList")
    l<HttpModel<List<MemberFriendApplyBean>>> memberFriendGetApplyList();

    @GET("member/friend/getDoApplyList")
    l<HttpModel<List<MemberFriendApplyBean>>> memberFriendGetDoApplyList();

    @GET("member/friend/getList")
    l<HttpModel<List<MemberFriendBean>>> memberFriendGetList();

    @FormUrlEncoded
    @POST("member/friend/reject")
    l<HttpModel<String>> memberFriendReject(@Field("applyId") Integer num);

    @FormUrlEncoded
    @POST("member/friend/update")
    l<HttpModel<String>> memberFriendUpdate(@Field("friendId") Integer num, @Field("friendName") String str);

    @FormUrlEncoded
    @POST("auth/third/login")
    l<HttpModel<LoginResultBean>> otherLogin(@Field("openId") String str, @Field("type") String str2);

    @FormUrlEncoded
    @POST("auth/register")
    l<HttpModel<LoginResultBean>> register(@Field("account") String str, @Field("password") String str2, @Field("verifyCode") String str3);

    @FormUrlEncoded
    @POST("member/resetPassword")
    l<HttpModel<String>> resetPassword(@Field("account") String str, @Field("password") String str2, @Field("verifyCode") String str3);

    @POST("member/saveSwitch")
    l<HttpModel<String>> saveSwitch(@Body RequestBody requestBody);

    @FormUrlEncoded
    @POST("member/sendVerifyCode")
    l<HttpModel<Object>> sendVerifyCode(@Field("account") String str, @Field("verifyCodeType") int i3);

    @FormUrlEncoded
    @POST("member/updatePassword")
    l<HttpModel<String>> updatePassword(@Field("oldPassword") String str, @Field("newPassword") String str2);

    @FormUrlEncoded
    @POST("member/update")
    l<HttpModel<String>> updateUserInfo(@Field("name") String str, @Field("birthday") String str2, @Field("sex") String str3, @Field("height") String str4, @Field("weight") String str5, @Field("portraitUrl") String str6, @Field("sportTarget") String str7);
}
