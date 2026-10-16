package com.amap.api.maps;

import android.content.Context;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.m1;
import com.amap.api.col.p0003sl.r4;
import com.amap.api.col.p0003sl.t4;
import com.amap.api.maps.model.LatLng;

/* loaded from: classes.dex */
public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private Context ctx;
    private CoordType coordType = null;
    private LatLng sourceLatLng = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.ctx = context;
    }

    public static boolean isAMapDataAvailable(double d5, double d8) {
        return r4.b(d5, d8);
    }

    public LatLng convert() {
        String str;
        LatLng b3;
        String str2;
        CoordType coordType = this.coordType;
        LatLng latLng = null;
        if (coordType == null || this.sourceLatLng == null) {
            return null;
        }
        try {
            switch (coordType) {
                case BAIDU:
                    latLng = m1.a(this.sourceLatLng);
                    str = "baidu";
                    break;
                case MAPBAR:
                    latLng = m1.a(this.ctx, this.sourceLatLng);
                    str = "mapbar";
                    break;
                case GPS:
                    b3 = m1.b(this.ctx, this.sourceLatLng);
                    str2 = "gps";
                    String str3 = str2;
                    latLng = b3;
                    str = str3;
                    break;
                case MAPABC:
                    b3 = this.sourceLatLng;
                    str2 = "mapabc";
                    String str32 = str2;
                    latLng = b3;
                    str = str32;
                    break;
                case SOSOMAP:
                    b3 = this.sourceLatLng;
                    str2 = "sosomap";
                    String str322 = str2;
                    latLng = b3;
                    str = str322;
                    break;
                case ALIYUN:
                    b3 = this.sourceLatLng;
                    str2 = "aliyun";
                    String str3222 = str2;
                    latLng = b3;
                    str = str3222;
                    break;
                case GOOGLE:
                    b3 = this.sourceLatLng;
                    str2 = "google";
                    String str32222 = str2;
                    latLng = b3;
                    str = str32222;
                    break;
                default:
                    str = "";
                    break;
            }
            t4.a(this.ctx, str);
            return latLng;
        } catch (Throwable th2) {
            th2.printStackTrace();
            ka.a(th2, TAG, "convert");
            return this.sourceLatLng;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.sourceLatLng = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.coordType = coordType;
        return this;
    }
}
