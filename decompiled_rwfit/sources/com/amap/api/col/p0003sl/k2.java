package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import okhttp3.HttpUrl;
import org.json.JSONObject;
import r5.a;

@ua(isSuperField = true, tableName = "update_item")
/* loaded from: classes.dex */
public class k2 extends n2 {

    /* renamed from: n, reason: collision with root package name */
    private String f4366n = "";

    /* renamed from: o, reason: collision with root package name */
    private Context f4367o;

    public k2() {
    }

    public void e(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if (!"".equals(str) && (jSONObject = new JSONObject(str).getJSONObject(Const.STR_FILE)) != null) {
                    this.f4676a = jSONObject.optString("title");
                    this.f4678c = jSONObject.optString("code");
                    this.f4677b = jSONObject.optString("url");
                    this.f4679d = jSONObject.optString("fileName");
                    this.f4680f = jSONObject.optLong("lLocalLength");
                    this.f4681g = jSONObject.optLong("lRemoteLength");
                    this.f4686l = jSONObject.optInt("mState");
                    this.e = jSONObject.optString("version");
                    this.f4682h = jSONObject.optString("localPath");
                    this.f4366n = jSONObject.optString("vMapFileNames");
                    this.f4683i = jSONObject.optInt("isSheng");
                    this.f4684j = jSONObject.optInt("mCompleteCode");
                    this.f4685k = jSONObject.optString("mCityCode");
                    String trim = (!jSONObject.has("pinyin") || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(jSONObject.getString("pinyin"))) ? "" : jSONObject.optString("pinyin").trim();
                    this.f4687m = trim;
                    if ("".equals(trim)) {
                        String str2 = this.f4677b;
                        String substring = str2.substring(str2.lastIndexOf("/") + 1);
                        this.f4687m = substring.substring(0, substring.lastIndexOf("."));
                    }
                }
            } catch (Throwable th2) {
                ka.a(th2, "UpdateItem", "readFileToJSONObject");
                th2.printStackTrace();
            }
        }
    }

    public String f() {
        return this.f4366n;
    }

    public void g() {
        this.f4679d = a.f(l0.t(v4.a(this.f4367o)), this.f4687m, ".zip.tmp");
    }

    public void h() {
        OutputStreamWriter outputStreamWriter;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.f4676a);
            jSONObject2.put("code", this.f4678c);
            jSONObject2.put("url", this.f4677b);
            jSONObject2.put("fileName", this.f4679d);
            jSONObject2.put("lLocalLength", this.f4680f);
            jSONObject2.put("lRemoteLength", this.f4681g);
            jSONObject2.put("mState", this.f4686l);
            jSONObject2.put("version", this.e);
            jSONObject2.put("localPath", this.f4682h);
            String str = this.f4366n;
            if (str != null) {
                jSONObject2.put("vMapFileNames", str);
            }
            jSONObject2.put("isSheng", this.f4683i);
            jSONObject2.put("mCompleteCode", this.f4684j);
            jSONObject2.put("mCityCode", this.f4685k);
            jSONObject2.put("pinyin", this.f4687m);
            jSONObject.put(Const.STR_FILE, jSONObject2);
            File file = new File(this.f4679d + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                try {
                    try {
                        outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    outputStreamWriter.write(jSONObject.toString());
                    outputStreamWriter.close();
                } catch (IOException e10) {
                    e = e10;
                    outputStreamWriter2 = outputStreamWriter;
                    ka.a(e, "UpdateItem", "saveJSONObjectToFile");
                    e.printStackTrace();
                    if (outputStreamWriter2 != null) {
                        outputStreamWriter2.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamWriter2 = outputStreamWriter;
                    if (outputStreamWriter2 != null) {
                        try {
                            outputStreamWriter2.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e12.printStackTrace();
            }
        } catch (Throwable th4) {
            ka.a(th4, "UpdateItem", "saveJSONObjectToFile parseJson");
            th4.printStackTrace();
        }
    }

    public void f(String str) {
        this.f4366n = str;
    }

    public k2(OfflineMapCity offlineMapCity, Context context) {
        this.f4367o = context;
        this.f4676a = offlineMapCity.getCity();
        this.f4678c = offlineMapCity.getAdcode();
        this.f4677b = offlineMapCity.getUrl();
        this.f4681g = offlineMapCity.getSize();
        this.e = offlineMapCity.getVersion();
        this.f4685k = offlineMapCity.getCode();
        this.f4683i = 0;
        this.f4686l = offlineMapCity.getState();
        this.f4684j = offlineMapCity.getcompleteCode();
        this.f4687m = offlineMapCity.getPinyin();
        g();
    }

    public k2(OfflineMapProvince offlineMapProvince, Context context) {
        this.f4367o = context;
        this.f4676a = offlineMapProvince.getProvinceName();
        this.f4678c = offlineMapProvince.getProvinceCode();
        this.f4677b = offlineMapProvince.getUrl();
        this.f4681g = offlineMapProvince.getSize();
        this.e = offlineMapProvince.getVersion();
        this.f4683i = 1;
        this.f4686l = offlineMapProvince.getState();
        this.f4684j = offlineMapProvince.getCompleteCode();
        this.f4687m = offlineMapProvince.getPinyin();
        g();
    }
}
