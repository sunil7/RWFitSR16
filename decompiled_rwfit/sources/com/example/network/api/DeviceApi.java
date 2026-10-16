package com.example.network.api;

import com.example.network.base.HttpModel;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.network.bean.DeviceSupportBean;
import com.example.network.bean.DialBean;
import com.example.network.bean.DialListBean;
import com.example.network.bean.DialPageBean;
import com.example.network.bean.FirmwareInfoBean;
import com.example.network.bean.LocationServerInfoBean;
import com.example.network.bean.WeatherInfoBean;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rg.l;

/* loaded from: classes.dex */
public interface DeviceApi {
    @FormUrlEncoded
    @POST("device/active")
    l<HttpModel<String>> activeDevice(@Field("deviceId") String str, @Field("model") String str2);

    @GET("device/getClassifyDials")
    l<HttpModel<List<DialListBean>>> getClassDialList(@Query("deviceId") String str, @Query("language") String str2);

    @GET("deviceSupport/getByMemberId")
    l<HttpModel<DeviceSupportBean>> getDeviceSupportByMemberId(@Query("memberId") int i3);

    @GET("device/getHomeSuggestDials")
    l<HttpModel<List<DialBean>>> getDialList(@Query("deviceId") String str);

    @GET("device/getDials")
    l<HttpModel<DialPageBean>> getDialPage(@Query("classify") int i3, @Query("deviceId") String str, @Query("pageIndex") int i10, @Query("pageSize") int i11);

    @GET("device/getOtaUpgradeInfo")
    l<HttpModel<FirmwareInfoBean>> getFirmwareInfo(@Query("currentVersion") String str, @Query("deviceId") String str2, @Query("platform") Integer num, @Query("appversion") String str3);

    @GET("device/getFontUpgradeInfo")
    l<HttpModel<FirmwareInfoBean>> getFontUpgradeInfo(@Query("currentVersion") String str, @Query("deviceId") String str2);

    @GET("device/getAddress")
    l<HttpModel<LocationServerInfoBean>> getLocationInfo(@Query("lon") String str, @Query("lat") String str2);

    @GET("device/getLogoUpgradeInfo")
    l<HttpModel<FirmwareInfoBean>> getLogoUpgradeInfo(@Query("currentVersion") String str, @Query("deviceId") String str2);

    @GET("member/getModelInfo")
    l<HttpModel<DeviceModelInfoBean>> getModelInfo(@Query("model") String str);

    @GET("device/getUIUpgradeInfo")
    l<HttpModel<FirmwareInfoBean>> getUiUpgradeInfo(@Query("currentVersion") String str, @Query("deviceId") String str2);

    @GET("device/getWeather")
    l<HttpModel<List<WeatherInfoBean>>> getWeather(@Query("lon") String str, @Query("lat") String str2);

    @GET("device/getForeignWeather")
    l<HttpModel<List<WeatherInfoBean>>> getWeather(@Query("lon") String str, @Query("lat") String str2, @Query("date") String str3);

    @FormUrlEncoded
    @POST("device/saveUseDials")
    l<HttpModel<String>> installDial(@Field("deviceId") String str, @Field("dials") String str2);

    @POST("deviceSupport/save")
    l<HttpModel<String>> saveDeviceSupport(@Body Map<String, Object> map);
}
