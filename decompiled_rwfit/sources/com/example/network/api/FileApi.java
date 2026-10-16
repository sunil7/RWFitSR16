package com.example.network.api;

import com.example.network.base.HttpModel;
import com.example.network.bean.FileBean;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import rg.l;

/* loaded from: classes.dex */
public interface FileApi {
    @POST("member/uploadFile")
    @Multipart
    l<HttpModel<FileBean>> uploadFile(@PartMap Map<String, RequestBody> map);
}
