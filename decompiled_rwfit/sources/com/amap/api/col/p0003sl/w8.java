package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class w8 extends u8<List<TraceLocation>, List<LatLng>> implements Runnable {
    private List<TraceLocation> r;

    /* renamed from: s, reason: collision with root package name */
    private Handler f5231s;

    /* renamed from: t, reason: collision with root package name */
    private int f5232t;

    /* renamed from: u, reason: collision with root package name */
    private int f5233u;

    /* renamed from: v, reason: collision with root package name */
    private String f5234v;

    public w8(Context context, Handler handler, List list, String str, int i3, int i10) {
        super(context, list);
        this.r = list;
        this.f5231s = handler;
        this.f5233u = i3;
        this.f5232t = i10;
        this.f5234v = str;
    }

    @Override // com.amap.api.col.p0003sl.t8
    public Object b(String str) throws s8 {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(AeUtil.ROOT_DATA_PATH_OLD_NAME) && (optJSONArray = jSONObject.optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME).optJSONArray("points")) != null && optJSONArray.length() != 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.amap.api.col.p0003sl.u8
    public String f() {
        JSONArray jSONArray = new JSONArray();
        long j4 = 0;
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            TraceLocation traceLocation = this.r.get(i3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i3 == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (time != 0) {
                        long j10 = time - j4;
                        if (j10 >= 1000) {
                            jSONObject.put("tm", j10 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j4 = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.f5096p = getURL() + Const.STR_MART_ADD + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        return v4.a(getURL(), this.f5095o);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        String str = "key=" + b9.e(this.f5095o);
        String c9 = e9.c();
        String n4 = l0.n("&ts=", c9);
        String n8 = l0.n("&scode=", e9.a(this.f5095o, c9, str));
        return ("http://" + g9.b(this.f5095o).a(41)) + "/v4/grasproad/driving?" + str + n4 + n8;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public boolean isSupportIPV6() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        new ArrayList();
        try {
            try {
                y8.a().a(this.f5234v, this.f5232t, c());
                y8.a().a(this.f5234v).a(this.f5231s);
            } catch (s8 e) {
                y8.a().a(this.f5231s, this.f5233u, e.a());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
