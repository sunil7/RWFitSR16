package com.example.network.api;

import com.example.network.base.HttpModel;
import com.example.network.bean.BoServerDailyBean;
import com.example.network.bean.BpServerDailyBean;
import com.example.network.bean.BreatheServerDailyBean;
import com.example.network.bean.BtServerDailyBean;
import com.example.network.bean.HrServerDailyBean;
import com.example.network.bean.HrvServerDailyBean;
import com.example.network.bean.PressureServerDailyBean;
import com.example.network.bean.RememberServerDailyBean;
import com.example.network.bean.SleepServerDailyBean;
import com.example.network.bean.SportServerDailyBean;
import com.example.network.bean.StepServerDailyBean;
import com.example.network.bean.SugarServerDailyBean;
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
public interface DataApi {
    @FormUrlEncoded
    @POST("data/clearMixSport")
    l<HttpModel<String>> delSportData(@Field("timestamp") int i3);

    @GET("data/getOxygens")
    l<HttpModel<List<BoServerDailyBean>>> downloadBos(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getBloodPressures")
    l<HttpModel<List<BpServerDailyBean>>> downloadBps(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getBreathes")
    l<HttpModel<List<BreatheServerDailyBean>>> downloadBreathes(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getTemperatures")
    l<HttpModel<List<BtServerDailyBean>>> downloadBts(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getHeartRates")
    l<HttpModel<List<HrServerDailyBean>>> downloadHrs(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getHrv")
    l<HttpModel<List<HrvServerDailyBean>>> downloadHrv(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getPressure")
    l<HttpModel<List<PressureServerDailyBean>>> downloadPressure(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getRemember")
    l<HttpModel<List<RememberServerDailyBean>>> downloadRemember(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getSleeps")
    l<HttpModel<List<SleepServerDailyBean>>> downloadSleeps(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getMixSports")
    l<HttpModel<List<SportServerDailyBean>>> downloadSports(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getSteps")
    l<HttpModel<List<StepServerDailyBean>>> downloadSteps(@Query("startDate") String str, @Query("endDate") String str2);

    @GET("data/getSugar")
    l<HttpModel<List<SugarServerDailyBean>>> downloadSugar(@Query("startDate") String str, @Query("endDate") String str2);

    @POST("data/saveOxygens")
    l<HttpModel<String>> uploadBos(@Body RequestBody requestBody);

    @POST("data/saveBloodPressures")
    l<HttpModel<String>> uploadBps(@Body RequestBody requestBody);

    @POST("data/saveBreathes")
    l<HttpModel<String>> uploadBreathes(@Body RequestBody requestBody);

    @POST("data/saveTemperatures")
    l<HttpModel<String>> uploadBts(@Body RequestBody requestBody);

    @POST("data/saveHeartRates")
    l<HttpModel<String>> uploadHrs(@Body RequestBody requestBody);

    @POST("data/saveHrv")
    l<HttpModel<String>> uploadHrv(@Body RequestBody requestBody);

    @POST("data/savePressure")
    l<HttpModel<String>> uploadPressure(@Body RequestBody requestBody);

    @POST("data/saveRemember")
    l<HttpModel<String>> uploadRemember(@Body RequestBody requestBody);

    @POST("data/saveSleeps")
    l<HttpModel<String>> uploadSleeps(@Body RequestBody requestBody);

    @POST("data/saveMixSports")
    l<HttpModel<String>> uploadSports(@Body RequestBody requestBody);

    @POST("data/saveSteps")
    l<HttpModel<String>> uploadSteps(@Body RequestBody requestBody);

    @POST("data/saveSugar")
    l<HttpModel<String>> uploadSugar(@Body RequestBody requestBody);
}
